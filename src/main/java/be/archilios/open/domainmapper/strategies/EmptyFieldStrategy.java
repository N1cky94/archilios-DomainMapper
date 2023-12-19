package be.archilios.open.domainmapper.strategies;

import be.archilios.open.domainmapper.exceptions.MappingException;

public sealed interface EmptyFieldStrategy {
    
    <T> T handle(Class<T> clazz);
    
    final class EmptyFieldDefaultStrategy implements EmptyFieldStrategy {
        @Override
        public <T> T handle(Class<T> clazz) {
            if (clazz.isPrimitive()) {
                EmptyFieldStrategy looseStrategy = new EmptyFieldLooseStrategy();
                return looseStrategy.handle(clazz);
            }
            throw new MappingException("Mapping not allowed because no default is know for empty field of type " + clazz.getSimpleName() + ", strategy DEFAULT requires default value to be declared when empty");
        }
    }
    
    final class EmptyFieldLooseStrategy implements EmptyFieldStrategy {
        @Override
        public <T> T handle(Class<T> clazz) {
            if (clazz.isPrimitive()) {
                return switch (clazz.getSimpleName()) {
                    case "boolean" -> (T) Boolean.FALSE;
                    case "byte" -> (T) Byte.valueOf("0");
                    case "short" -> (T) Short.valueOf("0");
                    case "int" -> (T) Integer.valueOf("0");
                    case "long" -> (T) Long.valueOf("0");
                    case "float" -> (T) Float.valueOf("0");
                    case "double" -> (T) Double.valueOf("0");
                    case "char" -> (T) Character.valueOf('\u0000');
                    default -> throw new IllegalStateException("Unexpected value: " + clazz.getSimpleName());
                };
            }
            return null;
        }
    }
    
    final class EmptyFieldStrictStrategy implements EmptyFieldStrategy {
        @Override
        public <T> T handle(Class<T> clazz) {
            throw new MappingException("Mapping not allowed because of empty field with type " + clazz.getSimpleName() + " and strategy STRICT");
        }
    }
}
