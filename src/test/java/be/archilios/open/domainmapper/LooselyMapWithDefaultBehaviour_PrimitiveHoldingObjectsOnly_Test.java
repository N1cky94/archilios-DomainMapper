package be.archilios.open.domainmapper;

import be.archilios.open.domainmapper.config.MappingStrategyPattern;
import be.archilios.open.domainmapper.data.PrimitiveOnlyData;
import be.archilios.open.domainmapper.data.PrimitiveOnlyDataMother;
import be.archilios.open.domainmapper.data.PrimitiveOnlyDataReceiver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LooselyMapWithDefaultBehaviour_PrimitiveHoldingObjectsOnly_Test {
    
    @Test
    void looselyMapPrimitiveHoldingObjectsOnly() {
        // Arrange
        PrimitiveOnlyData source = PrimitiveOnlyDataMother.data()
                .build();
        
        DomainMapper mapper = new DomainMapper(MappingStrategyPattern.LOOSELY);
        
        // Act
        PrimitiveOnlyDataReceiver destination = mapper.map(source, PrimitiveOnlyDataReceiver.class);
        
        // Assert
        assertEquals(source.getName(), destination.getName(), "Name should be mapped");
        assertEquals(source.getAge(), destination.getAge(), "Age should be mapped");
        assertEquals(source.isAdult(), destination.isAdult(), "Adult should be mapped");
        assertEquals(0, destination.getId(), "Id should not be mapped");
    }
}
