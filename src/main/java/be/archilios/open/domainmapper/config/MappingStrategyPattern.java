package be.archilios.open.domainmapper.config;

import be.archilios.open.domainmapper.strategies.EmptyFieldStrategy;

public enum MappingStrategyPattern {
    LOOSELY(new EmptyFieldStrategy.EmptyFieldLooseStrategy()),
    STRICT(new EmptyFieldStrategy.EmptyFieldStrictStrategy()),
    DEFAULT(new EmptyFieldStrategy.EmptyFieldDefaultStrategy());
    
    private final EmptyFieldStrategy emptyFieldStrategy;
    
    MappingStrategyPattern(EmptyFieldStrategy emptyFieldStrategy) {
        this.emptyFieldStrategy = emptyFieldStrategy;
    }
    
    public Object handleEmptyField(Class<?> clazz) {
        return emptyFieldStrategy.handle(clazz);
    }
}
