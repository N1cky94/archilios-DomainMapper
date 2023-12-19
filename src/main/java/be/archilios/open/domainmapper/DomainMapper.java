package be.archilios.open.domainmapper;

import be.archilios.open.domainmapper.config.MappingStrategyPattern;
import be.archilios.open.domainmapper.exceptions.MappingException;

import java.lang.reflect.Field;

public class DomainMapper {
    private final MappingStrategyPattern mappingStrategy;
    
    public DomainMapper() {
        this(MappingStrategyPattern.LOOSELY);
    }
    
    public DomainMapper(MappingStrategyPattern mappingStrategy) {
        this.mappingStrategy = mappingStrategy;
    }
    
    public MappingStrategyPattern getActiveMappingStrategy() {
        return mappingStrategy;
    }
    
    public <T, V> T map(V source, Class<T> targetClass) {
        try {
            return tryMap(source, targetClass);
        } catch (Exception e) {
            throw new MappingException("Could not map " + source.getClass().getSimpleName() + " to " + targetClass.getSimpleName(), e);
        }
    }
    
    private <T, V> T tryMap(V source, Class<T> targetClass) throws Exception {
        T result = targetClass.getDeclaredConstructor().newInstance();
        
        Field[] sourceFields = source.getClass().getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();
        
        mapFields(source, sourceFields, targetFields, result);
        handleEmptyFields(targetFields, result);
        
        if (getActiveMappingStrategy() == MappingStrategyPattern.STRICT) {
            throw new MappingException("Could not map " + source.getClass().getSimpleName() + " to " + targetClass.getSimpleName() + " because of possible missing fields");
        }
        
        return result;
    }
    
    private static <T, V> void mapFields(V source, Field[] sourceFields, Field[] targetFields, T result) throws IllegalAccessException {
        for (Field sourceField : sourceFields) {
            for (Field targetField : targetFields) {
                if (sourceField.getName().equals(targetField.getName())) {
                    sourceField.setAccessible(true);
                    targetField.setAccessible(true);
                    targetField.set(result, sourceField.get(source));
                }
            }
        }
    }
    
    private <T> void handleEmptyFields(Field[] targetFields, T result) throws IllegalAccessException {
        for (Field targetField : targetFields) {
            if (!targetField.canAccess(result)) {
                targetField.setAccessible(true);
                targetField.set(result, mappingStrategy.handleEmptyField(targetField.getType()));
            }
        }
    }
    
}
