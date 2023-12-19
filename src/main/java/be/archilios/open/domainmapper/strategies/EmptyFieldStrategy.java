package be.archilios.open.domainmapper.strategies;

import be.archilios.open.domainmapper.exceptions.MappingException;

public sealed interface EmptyFieldStrategy {
    
    <T> T handle(Class<T> clazz);
    
    final class EmptyFieldDefaultStrategy implements EmptyFieldStrategy {
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
                    default -> throw new IllegalStateException("Unexpected value: " + clazz.getSimpleName());
                };
            }
            return null;
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