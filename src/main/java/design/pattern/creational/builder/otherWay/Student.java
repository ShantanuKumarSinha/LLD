package design.pattern.creational.builder.otherWay;

import java.time.LocalDate;

public class Student {

  private String id;
  private String name;
  private String email;
  private LocalDate birthday;
  private String address;

  public Student(StudentBuilder studentBuilder) {
    this.id = studentBuilder.id;
    this.name = studentBuilder.name;
    this.email = studentBuilder.email;
    this.birthday = studentBuilder.birthday;
    this.address = studentBuilder.address;
  }

  public static StudentBuilder builder() {
    return new StudentBuilder();
  }

  @Override
  public String toString() {
    return "Student{"
        + "address='"
        + address
        + '\''
        + ", id='"
        + id
        + '\''
        + ", name='"
        + name
        + '\''
        + ", email='"
        + email
        + '\''
        + ", birthday="
        + birthday
        + '}';
  }
}
