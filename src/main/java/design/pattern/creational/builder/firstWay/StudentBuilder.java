package design.pattern.creational.builder.firstWay;

public class StudentBuilder {

    private Student student;

    public StudentBuilder(Student student) {
        this.student = student;
    }

    public StudentBuilder id(long id) {
        student.setId(id);
        return this;
    }
    public StudentBuilder name(String name) {
        student.setName(name);
        return this;
    }
    public StudentBuilder email(String email) {
        student.setEmail(email);
        return this;
    }
    public StudentBuilder phone(String phone) {
        student.setPhone(phone);
        return this;
    }
    public StudentBuilder address(String address) {
        student.setAddress(address);
        return this;
    }


    public Student build(){
        return student;
    }
}
