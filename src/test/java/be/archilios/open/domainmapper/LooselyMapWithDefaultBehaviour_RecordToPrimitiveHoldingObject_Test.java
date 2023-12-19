package be.archilios.open.domainmapper;

import be.archilios.open.domainmapper.config.MappingStrategyPattern;
import be.archilios.open.domainmapper.data.PrimitiveOnlyData;
import be.archilios.open.domainmapper.data.PrimitiveOnlyRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LooselyMapWithDefaultBehaviour_RecordToPrimitiveHoldingObject_Test {
    
    @Test
    void looselyMapRecordToPrimitiveHoldingObject() {
        // Arrange
        DomainMapper mapper = new DomainMapper(MappingStrategyPattern.LOOSELY);
        
        PrimitiveOnlyRecord source = new PrimitiveOnlyRecord(1, "Nick Bau", 32, true);
        PrimitiveOnlyData destination;
        
        // Act
        destination = mapper.map(source, PrimitiveOnlyData.class);
         
         // Assert
        assertEquals(source.name(), destination.getName(), "Name should be mapped");
        assertEquals(source.age(), destination.getAge(), "Age should be mapped");
        assertEquals(source.isAdult(), destination.isAdult(), "isAdult should be mapped");
        assertEquals(0, destination.getHeight(), "Height should not be mapped");
    }
    
}
