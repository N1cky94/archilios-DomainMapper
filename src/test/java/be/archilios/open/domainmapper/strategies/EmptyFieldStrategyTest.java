package be.archilios.open.domainmapper.strategies;

import be.archilios.open.domainmapper.config.MappingStrategyPattern;
import be.archilios.open.domainmapper.data.PrimitiveOnlyData;
import be.archilios.open.domainmapper.exceptions.MappingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmptyFieldStrategyTest {
    
    @Test
    void looseStrategyMapsToPrimitiveDefault() {
        MappingStrategyPattern pattern = MappingStrategyPattern.LOOSELY;
        
        assertEquals(0, pattern.handleEmptyField(int.class), "Should map to default value of integer");
        assertEquals(0L, pattern.handleEmptyField(long.class), "Should map to default value of long");
        assertEquals(0.0f, pattern.handleEmptyField(float.class), "Should map to default value of float");
        assertEquals(0.0, pattern.handleEmptyField(double.class), "Should map to default value of double");
        assertEquals(false, pattern.handleEmptyField(boolean.class), "Should map to default value of boolean");
        assertEquals('\u0000', pattern.handleEmptyField(char.class), "Should map to default value of char");
    }
    
    @Test
    void looseStrategyMapsToNull() {
        MappingStrategyPattern pattern = MappingStrategyPattern.LOOSELY;
        
        assertNull(pattern.handleEmptyField(String.class), "Should map to null");
    }
    
    @Test
    void defaultStrategyThrowsExceptionWhenFieldHasNoProvidedDefaultValue() {
        MappingStrategyPattern pattern = MappingStrategyPattern.DEFAULT;
        
        assertThrows(MappingException.class, () -> pattern.handleEmptyField(String.class), "Should throw exception when field has no default value defined");
    }
    
    @Test
    void defaultStrategyMapsToObjectsProvidedDefaultValue() {
        MappingStrategyPattern pattern = MappingStrategyPattern.DEFAULT;
        
        assertThrows(MappingException.class, () -> pattern.handleEmptyField(PrimitiveOnlyData.class), "Should be implemented later, is not a feature but a bug");
    }
    
    @Test
    void strictStrategyThrowsException() {
        MappingStrategyPattern pattern = MappingStrategyPattern.STRICT;
        
        assertThrows(MappingException.class, () -> pattern.handleEmptyField(int.class), "Should throw exception when field is empty in STRICT Mode");
        assertThrows(MappingException.class, () -> pattern.handleEmptyField(String.class), "Should throw exception when field is empty in STRICT Mode");
        assertThrows(MappingException.class, () -> pattern.handleEmptyField(PrimitiveOnlyData.class), "Should throw exception when field is empty in STRICT Mode");
    }
    
}
