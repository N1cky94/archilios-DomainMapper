package be.archilios.open.domainmapper.strategies;

import be.archilios.open.domainmapper.config.MappingStrategyPattern;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmptyFieldStrategyTest {
    
    @Test
    void looseEmptyFieldStrategyMapsToPrimitiveDefault() {
        MappingStrategyPattern pattern = MappingStrategyPattern.LOOSELY;
        
        assertEquals(0, pattern.handleEmptyField(int.class), "Should map to default value of integer");
        assertEquals(0L, pattern.handleEmptyField(long.class), "Should map to default value of long");
        assertEquals(0.0f, pattern.handleEmptyField(float.class), "Should map to default value of float");
        assertEquals(0.0, pattern.handleEmptyField(double.class), "Should map to default value of double");
        assertEquals(false, pattern.handleEmptyField(boolean.class), "Should map to default value of boolean");
        assertEquals('\u0000', pattern.handleEmptyField(char.class), "Should map to default value of char");
    }
    
}
