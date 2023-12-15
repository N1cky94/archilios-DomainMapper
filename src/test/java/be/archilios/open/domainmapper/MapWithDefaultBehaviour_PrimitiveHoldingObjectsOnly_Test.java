package be.archilios.open.domainmapper;

import be.archilios.open.domainmapper.data.PrimitiveOnlyData;
import be.archilios.open.domainmapper.data.PrimitiveOnlyDataMother;
import be.archilios.open.domainmapper.data.PrimitiveOnlyDataReceiver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapWithDefaultBehaviour_PrimitiveHoldingObjectsOnly_Test {
    private final DomainMapper domainMapper = new DomainMapper();
    private final PrimitiveOnlyData source = PrimitiveOnlyDataMother.data().build();;
    private final PrimitiveOnlyDataReceiver doubleBlindSource = new PrimitiveOnlyDataReceiver();
    
    @BeforeEach
    void setUp() {
        doubleBlindSource.setId(1L);
        doubleBlindSource.setName("Jane Doe");
        doubleBlindSource.setAge(12);
        doubleBlindSource.setAdult(false);
    }
    
    
    @Test
    void mapPrimitiveHoldingObjectsOnly() {
        // Act
        PrimitiveOnlyDataReceiver result = domainMapper.map(source, PrimitiveOnlyDataReceiver.class);
        
        // Assert
        assertEquals(source.getName(), result.getName(), "Name should be mapped");
        assertEquals(source.getAge(), result.getAge(), "Age should be mapped");
        assertEquals(source.isAdult(), result.isAdult(), "Adult should be mapped");
        assertEquals(0, result.getId(), "Id should not be mapped");
    }
    
    @Test
    void reverseMapPrimitiveHoldingObjectsOnly() {
        // Act
        PrimitiveOnlyData result = domainMapper.map(doubleBlindSource, PrimitiveOnlyData.class);
        
        // Assert
        assertEquals(doubleBlindSource.getName(), result.getName(), "Name should be mapped");
        assertEquals(doubleBlindSource.getAge(), result.getAge(), "Age should be mapped");
        assertEquals(doubleBlindSource.isAdult(), result.isAdult(), "Adult should be mapped");
        assertEquals(0.0, result.getHeight(), "Height should not be mapped");
    }
}