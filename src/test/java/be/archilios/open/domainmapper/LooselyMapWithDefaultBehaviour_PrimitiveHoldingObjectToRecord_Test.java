package be.archilios.open.domainmapper;

import be.archilios.open.domainmapper.config.MappingStrategyPattern;
import be.archilios.open.domainmapper.data.PrimitiveOnlyData;
import be.archilios.open.domainmapper.data.PrimitiveOnlyDataMother;
import be.archilios.open.domainmapper.data.PrimitiveOnlyRecord;
import be.archilios.open.domainmapper.exceptions.MappingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LooselyMapWithDefaultBehaviour_PrimitiveHoldingObjectToRecord_Test {
    
    @Test
    void looselyMapPrimitiveHoldingObjectToRecord() {
        // Arrange
        DomainMapper mapper = new DomainMapper(MappingStrategyPattern.LOOSELY);
        PrimitiveOnlyData source = PrimitiveOnlyDataMother.data().build();
        
        assertThrows(MappingException.class, () -> mapper.map(source, PrimitiveOnlyRecord.class));
    }
}
