package be.archilios.open.domainmapper.data;

public class PrimitiveDataPojo {
    private String name;
    private int age;
    private boolean isAdult;
    private double height;
    
    public PrimitiveDataPojo() {
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public boolean isAdult() {
        return isAdult;
    }
    
    public void setAdult(boolean adult) {
        isAdult = adult;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        PrimitiveDataPojo that = (PrimitiveDataPojo) o;
        
        if (getAge() != that.getAge()) return false;
        if (isAdult() != that.isAdult()) return false;
        if (Double.compare(getHeight(), that.getHeight()) != 0) return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }
    
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        result = 31 * result + (isAdult() ? 1 : 0);
        temp = Double.doubleToLongBits(getHeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    
    @Override
    public String toString() {
        return "PrimitiveDataPojo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isAdult=" + isAdult +
                ", height=" + height +
                '}';
    }
}
