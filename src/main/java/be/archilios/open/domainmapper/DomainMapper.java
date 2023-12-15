package be.archilios.open.domainmapper;

import be.archilios.open.domainmapper.config.MappingStrategyPattern;
import be.archilios.open.domainmapper.exceptions.MappingException;

import java.lang.reflect.Field;

public class DomainMapper {
    private final MappingStrategyPattern mappingStrategy;
    
    public DomainMapper(MappingStrategyPattern mappingStrategy) {
        this.mappingStrategy = mappingStrategy;
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
        
        for (Field sourceField : sourceFields) {
            for (Field targetField : targetFields) {
                if (sourceField.getName().equals(targetField.getName())) {
                    sourceField.setAccessible(true);
                    targetField.setAccessible(true);
                    targetField.set(result, sourceField.get(Source));
                }
            }
        }
        
        return result;
    }

}
