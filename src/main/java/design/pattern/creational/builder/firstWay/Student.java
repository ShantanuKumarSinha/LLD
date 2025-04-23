package design.pattern.creational.builder.firstWay;

public class Student {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String address;


    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static StudentBuilder builder(){
        return new StudentBuilder(new Student());
    }

    @Override
    public String toString() {
        return "Student{" +
                "address='" + address + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
