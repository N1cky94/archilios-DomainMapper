package be.archilios.open.domainmapper;

import be.archilios.open.domainmapper.config.MappingStrategyPattern;
import be.archilios.open.domainmapper.data.PrimitiveOnlyData;
import be.archilios.open.domainmapper.data.PrimitiveOnlyDataMother;
import be.archilios.open.domainmapper.data.PrimitiveOnlyDataReceiver;
import be.archilios.open.domainmapper.data.PrimitiveOnlyRecord;
import be.archilios.open.domainmapper.exceptions.MappingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapWithLooseStrategyTest {
    @Test
    void primitiveObjectToPrimitiveObject() {
        // Arrange
        PrimitiveOnlyData source = PrimitiveOnlyDataMother.data()
                .buildObject();
        
        DomainMapper mapper = new DomainMapper(MappingStrategyPattern.LOOSELY);
        
        // Act
        PrimitiveOnlyDataReceiver destination = mapper.map(source, PrimitiveOnlyDataReceiver.class);
        
        // Assert
        assertEquals(source.getName(), destination.getName(), "Name should be mapped");
        assertEquals(source.getAge(), destination.getAge(), "Age should be mapped");
        assertEquals(source.isAdult(), destination.isAdult(), "Adult should be mapped");
        assertEquals(0, destination.getId(), "Id should not be mapped");
    }
    
    @Test
    void primitiveRecordToPrimitiveObject() {
        // Arrange
        DomainMapper mapper = new DomainMapper(MappingStrategyPattern.LOOSELY);
        
        PrimitiveOnlyRecord source = PrimitiveOnlyDataMother.data().buildRecord();
        PrimitiveOnlyData destination;
        
        // Act
        destination = mapper.map(source, PrimitiveOnlyData.class);
        
        // Assert
        assertEquals(source.name(), destination.getName(), "Name should be mapped");
        assertEquals(source.age(), destination.getAge(), "Age should be mapped");
        assertEquals(source.isAdult(), destination.isAdult(), "isAdult should be mapped");
        assertEquals(0, destination.getHeight(), "Height should not be mapped");
    }
    
    @Test
    void primitiveObjectToPrimitiveRecord() {
        // Arrange
        DomainMapper mapper = new DomainMapper(MappingStrategyPattern.LOOSELY);
        PrimitiveOnlyData source = PrimitiveOnlyDataMother.data().buildObject();
        
        assertThrows(MappingException.class, () -> mapper.map(source, PrimitiveOnlyRecord.class));
    }
}
