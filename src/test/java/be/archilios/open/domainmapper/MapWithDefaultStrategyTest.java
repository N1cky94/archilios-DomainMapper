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

public class MapWithDefaultStrategyTest {
    private final DomainMapper mapper = new DomainMapper(MappingStrategyPattern.DEFAULT);
    @Test
    void primitiveObjectToPrimitiveObject() {
        PrimitiveOnlyData source = PrimitiveOnlyDataMother.data().buildObject();
        
        PrimitiveOnlyDataReceiver destination = mapper.map(source, PrimitiveOnlyDataReceiver.class);
        
        assertEquals(source.getName(), destination.getName(), "Name should be mapped");
        assertEquals(source.getAge(), destination.getAge(), "Age should be mapped");
        assertEquals(source.isAdult(), destination.isAdult(), "Adult should be mapped");
        assertEquals(0, destination.getId(), "Id should be mapped to default value");
    }
    
    @Test
    void primitiveObjectToItself() {
        final String changedName = "Dear";
        PrimitiveOnlyData source = PrimitiveOnlyDataMother.data().withName(changedName).buildObject();
        
        PrimitiveOnlyData destination = mapper.map(source, PrimitiveOnlyData.class);
        
        assertEquals(changedName, destination.getName(), "Name should be correctly mapped");
    }
    
    @Test
    void primitiveRecordToPrimitiveObject() {
        PrimitiveOnlyRecord source = PrimitiveOnlyDataMother.data().buildRecord();
        
        PrimitiveOnlyData destination = mapper.map(source, PrimitiveOnlyData.class);
        
        assertEquals(source.name(), destination.getName(), "Name should be mapped");
        assertEquals(source.age(), destination.getAge(), "Age should be mapped");
        assertEquals(source.isAdult(), destination.isAdult(), "isAdult should be mapped");
        assertEquals(0, destination.getHeight(), "Height should be mapped to default value");
    }
    
    @Test
    void primitiveObjectToPrimitiveRecord() {
        PrimitiveOnlyData source = PrimitiveOnlyDataMother.data().buildObject();
        
        assertThrows(MappingException.class, () -> mapper.map(source, PrimitiveOnlyRecord.class));
    }
    
    @Test
    void primitiveRecordToItself() {
        final String changedName = "Dear";
        PrimitiveOnlyRecord source = PrimitiveOnlyDataMother.data().withName(changedName).buildRecord();
        
        assertThrows(MappingException.class, () -> mapper.map(source, PrimitiveOnlyRecord.class));
    }
}
