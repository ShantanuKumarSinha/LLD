package design.pattern.creational.builder.otherWay;

import java.time.LocalDate;

public class StudentBuilder {

  String id;
  String name;
  String email;
  LocalDate birthday;
  String address;

  public StudentBuilder id(String id) {
    this.id = id;
    return this;
  }

  public StudentBuilder name(String name) {
    this.name = name;
    return this;
  }

  public StudentBuilder email(String email) {
    this.email = email;
    return this;
  }

  public StudentBuilder birthday(LocalDate birthday) {
    this.birthday = birthday;
    return this;
  }

  public StudentBuilder address(String address) {
    this.address = address;
    return this;
  }

  public Student build() {
    return new Student(this);
  }
}
