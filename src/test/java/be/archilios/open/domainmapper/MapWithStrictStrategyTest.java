package be.archilios.open.domainmapper;

import be.archilios.open.domainmapper.config.MappingStrategyPattern;
import be.archilios.open.domainmapper.data.PrimitiveOnlyData;
import be.archilios.open.domainmapper.data.PrimitiveOnlyDataMother;
import be.archilios.open.domainmapper.data.PrimitiveOnlyDataReceiver;
import be.archilios.open.domainmapper.exceptions.MappingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapWithStrictStrategyTest {
    
    @Test
    void primitiveObjectToPrimitiveObject() {
        // Arrange
        PrimitiveOnlyData source = PrimitiveOnlyDataMother.data().buildObject();
        DomainMapper mapper = new DomainMapper(MappingStrategyPattern.STRICT);
        
        assertThrows(MappingException.class, () -> mapper.map(source, PrimitiveOnlyDataReceiver.class));
    }
}
