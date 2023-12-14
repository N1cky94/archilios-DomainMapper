package be.archilios.open.domainmapper;

import be.archilios.open.domainmapper.exceptions.MappingException;

public class DomainMapper {
    
    public <T, V> T map(V source, Class<T> targetClass) {
        try {
            return tryMapping(source, targetClass);
        } catch (Exception e) {
            throw new MappingException("Could not map " + source.getClass().getSimpleName() + " to " + targetClass.getSimpleName(), e);
        }
    }

}
