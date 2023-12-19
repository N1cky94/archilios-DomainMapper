package be.archilios.open.domainmapper;

import be.archilios.open.domainmapper.config.MappingStrategyPattern;
import be.archilios.open.domainmapper.exceptions.MappingException;
import be.archilios.open.domainmapper.strategies.EmptyFieldStrategy;

import java.lang.reflect.Field;

public class DomainMapper {
    private final MappingStrategyPattern mappingStrategy;
    private EmptyFieldStrategy emptyFieldStrategy;
    
    public DomainMapper() {
        this(MappingStrategyPattern.LOOSELY);
    }
    
    public DomainMapper(MappingStrategyPattern mappingStrategy) {
        this.mappingStrategy = mappingStrategy;
        
        configureEmptyFieldStrategy();
    }
    
    private void configureEmptyFieldStrategy() {
        switch (mappingStrategy) {
            case LOOSELY -> emptyFieldStrategy = new EmptyFieldStrategy.EmptyFieldLooseStrategy();
            case STRICT -> emptyFieldStrategy = new EmptyFieldStrategy.EmptyFieldStrictStrategy();
            case DEFAULT -> emptyFieldStrategy = new EmptyFieldStrategy.EmptyFieldDefaultStrategy();
        }
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
    
    private <T, V> T tryMap(V Source, Class<T> targetClass) throws Exception {
        T result = targetClass.getDeclaredConstructor().newInstance();
        
        Field[] sourceFields = Source.getClass().getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();
        
        mapFields(Source, sourceFields, targetFields, result);
        handleEmptyFields(targetFields, result);
        
        if (getActiveMappingStrategy() == MappingStrategyPattern.STRICT) {
            throw new MappingException("Could not map " + Source.getClass().getSimpleName() + " to " + targetClass.getSimpleName() + " because of possible missing fields");
        }
        
        return result;
    }
    
    private static <T, V> void mapFields(V Source, Field[] sourceFields, Field[] targetFields, T result) throws IllegalAccessException {
        for (Field sourceField : sourceFields) {
            for (Field targetField : targetFields) {
                if (sourceField.getName().equals(targetField.getName())) {
                    sourceField.setAccessible(true);
                    targetField.setAccessible(true);
                    targetField.set(result, sourceField.get(Source));
                }
            }
        }
    }
    
    private <T> void handleEmptyFields(Field[] targetFields, T result) throws IllegalAccessException {
        for (Field targetField : targetFields) {
            if (!targetField.canAccess(result)) {
                targetField.setAccessible(true);
                targetField.set(result, emptyFieldStrategy.handle(targetField.getType()));
            }
        }
    }
    
}
