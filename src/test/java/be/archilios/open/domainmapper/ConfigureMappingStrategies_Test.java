package be.archilios.open.domainmapper;

import be.archilios.open.domainmapper.config.MappingStrategyPattern;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigureMappingStrategies_Test {
    
    @Test
    void DefaultsToLooseStrategy() {
        DomainMapper mapper = new DomainMapper();
        
        assertEquals(MappingStrategyPattern.LOOSELY, mapper.getActiveMappingStrategy());
    }
    
    @Test
    void CanSetLooseStrategy() {
        DomainMapper mapper = new DomainMapper(MappingStrategyPattern.LOOSELY);
        
        assertEquals(MappingStrategyPattern.LOOSELY, mapper.getActiveMappingStrategy());
    }
    
    @Test
    void CanSetStrictStrategy() {
        DomainMapper mapper = new DomainMapper(MappingStrategyPattern.STRICT);
        
        assertEquals(MappingStrategyPattern.STRICT, mapper.getActiveMappingStrategy());
    }
    
    @Test
    void canSetDefaultStrategy() {
        DomainMapper mapper = new DomainMapper(MappingStrategyPattern.DEFAULT);
        
        assertEquals(MappingStrategyPattern.DEFAULT, mapper.getActiveMappingStrategy());
    }
    
}
