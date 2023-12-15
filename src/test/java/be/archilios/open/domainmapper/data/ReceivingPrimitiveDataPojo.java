package be.archilios.open.domainmapper.data;

public class ReceivingPrimitiveDataPojo {
    private long id;
    private String name;
    private int age;
    private boolean isAdult;
    
    public ReceivingPrimitiveDataPojo() {
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        ReceivingPrimitiveDataPojo that = (ReceivingPrimitiveDataPojo) o;
        
        if (getId() != that.getId()) return false;
        if (getAge() != that.getAge()) return false;
        if (isAdult() != that.isAdult()) return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }
    
    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getAge();
        result = 31 * result + (isAdult() ? 1 : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "ReceivingPrimitiveDataPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isAdult=" + isAdult +
                '}';
    }
}
