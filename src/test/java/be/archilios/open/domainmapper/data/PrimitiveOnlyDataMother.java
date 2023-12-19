package be.archilios.open.domainmapper.data;

public class PrimitiveOnlyDataMother {
    private PrimitiveOnlyDataMother() {
    
    }
    
    public static Builder data() {
        return new Builder();
    }
    
    public static class Builder {
        private String name = "John Doe";
        private Long id = 1L;
        private int age = 42;
        private boolean isAdult = true;
        private double height = 1.83;
        
        public Builder withId(long id) {
            this.id = id;
            return this;
        }
        
        public Builder withName(String name) {
            this.name = name;
            return this;
        }
        
        public Builder withAge(int age) {
            this.age = age;
            return this;
        }
        
        public Builder withAdult(boolean adult) {
            isAdult = adult;
            return this;
        }
        
        public Builder withHeight(double height) {
            this.height = height;
            return this;
        }
        
        public PrimitiveOnlyData buildObject() {
            PrimitiveOnlyData result = new PrimitiveOnlyData();
            result.setName(name);
            result.setAge(age);
            result.setAdult(isAdult);
            result.setHeight(height);
            return result;
        }
        
        public PrimitiveOnlyRecord buildRecord() {
            return new PrimitiveOnlyRecord(1, name, age, isAdult);
        }
    }
    
}
