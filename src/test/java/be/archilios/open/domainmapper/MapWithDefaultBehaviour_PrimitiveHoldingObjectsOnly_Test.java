package be.archilios.open.domainmapper;

import be.archilios.open.domainmapper.data.PrimitiveOnlyData;
import be.archilios.open.domainmapper.data.PrimitiveOnlyDataReceiver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapWithDefaultBehaviour_PrimitiveHoldingObjectsOnly_Test {
    private final DomainMapper domainMapper = new DomainMapper();
    private final PrimitiveOnlyData pojoToBeMapped = new PrimitiveOnlyData();
    private final PrimitiveOnlyDataReceiver pojoToBeMappedReturn = new PrimitiveOnlyDataReceiver();
    
    @BeforeEach
    void setUp() {
        pojoToBeMapped.setName("John Doe");
        pojoToBeMapped.setAge(42);
        pojoToBeMapped.setAdult(true);
        pojoToBeMapped.setHeight(1.83);
        
        pojoToBeMappedReturn.setId(1L);
        pojoToBeMappedReturn.setName("Jane Doe");
        pojoToBeMappedReturn.setAge(12);
        pojoToBeMappedReturn.setAdult(false);
    }
    
    
    @Test
    void mapPrimitiveHoldingObjectsOnly() {
        // Act
        PrimitiveOnlyDataReceiver result = domainMapper.map(pojoToBeMapped, PrimitiveOnlyDataReceiver.class);
        
        // Assert
        assertEquals(pojoToBeMapped.getName(), result.getName(), "Name should be mapped");
        assertEquals(pojoToBeMapped.getAge(), result.getAge(), "Age should be mapped");
        assertEquals(pojoToBeMapped.isAdult(), result.isAdult(), "Adult should be mapped");
        assertEquals(0, result.getId(), "Id should not be mapped");
    }
    
    @Test
    void reverseMapPrimitiveHoldingObjectsOnly() {
        // Act
        PrimitiveOnlyData result = domainMapper.map(pojoToBeMappedReturn, PrimitiveOnlyData.class);
        
        // Assert
        assertEquals(pojoToBeMappedReturn.getName(), result.getName(), "Name should be mapped");
        assertEquals(pojoToBeMappedReturn.getAge(), result.getAge(), "Age should be mapped");
        assertEquals(pojoToBeMappedReturn.isAdult(), result.isAdult(), "Adult should be mapped");
        assertEquals(0.0, result.getHeight(), "Height should not be mapped");
    }
}