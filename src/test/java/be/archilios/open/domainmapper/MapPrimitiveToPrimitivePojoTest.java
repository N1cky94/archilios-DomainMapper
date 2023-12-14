package be.archilios.open.domainmapper;

import be.archilios.open.domainmapper.data.PrimitiveDataPojo;
import be.archilios.open.domainmapper.data.ReceivingPrimitiveDataPojo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapPrimitiveToPrimitivePojoTest {
    private final DomainMapper domainMapper = new DomainMapper();
    private final PrimitiveDataPojo pojoToBeMapped = new PrimitiveDataPojo();
    private final ReceivingPrimitiveDataPojo pojoToBeMappedReturn = new ReceivingPrimitiveDataPojo();
    
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
    void mapPrimitivePojoIntoOtherPrimitivePojoWithOverlappingFields() {
        // Act
        ReceivingPrimitiveDataPojo result = domainMapper.map(pojoToBeMapped, ReceivingPrimitiveDataPojo.class);
        
        // Assert
        assertEquals(pojoToBeMapped.getName(), result.getName(), "Name should be mapped");
        assertEquals(pojoToBeMapped.getAge(), result.getAge(), "Age should be mapped");
        assertEquals(pojoToBeMapped.isAdult(), result.isAdult(), "Adult should be mapped");
        assertEquals(0, result.getId(), "Id should not be mapped");
    }
    
    @Test
    void mapPrimitivePojoIntoOtherPrimitivePojoWithOverlappingFieldsDoubleBlind() {
        // Act
        PrimitiveDataPojo result = domainMapper.map(pojoToBeMappedReturn, PrimitiveDataPojo.class);
        
        // Assert
        assertEquals(pojoToBeMappedReturn.getName(), result.getName(), "Name should be mapped");
        assertEquals(pojoToBeMappedReturn.getAge(), result.getAge(), "Age should be mapped");
        assertEquals(pojoToBeMappedReturn.isAdult(), result.isAdult(), "Adult should be mapped");
        assertEquals(0.0, result.getHeight(), "Height should not be mapped");
    }
}