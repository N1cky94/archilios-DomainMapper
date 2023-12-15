package be.archilios.open.domainmapper;

import be.archilios.open.domainmapper.exceptions.MappingException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Stream;

public class DomainMapper {
    
    public <T, V> T map(V source, Class<T> targetClass) {
        try {
            return tryMap(source, targetClass);
        } catch (Exception e) {
            throw new MappingException("Could not map " + source.getClass().getSimpleName() + " to " + targetClass.getSimpleName(), e);
        }
    }
    
    private <T, V> T tryMap(V Source, Class<T> targetClass) throws Exception {
        //todo: map the source to the target untill the tests succeed
        //   1. [X] Get a returnable result
        //   2. [X] Get the fields of the source
        //   3. [X] Get the fields of the target
        //   4. [X] Loop over the source fields and check which ones are present with the same name in the target
        //   5. [X] For all fields that can be found in both, copy the value from the source to the target
        
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
