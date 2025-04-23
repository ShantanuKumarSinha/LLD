package design.pattern.creational.builder.otherWay;

import java.time.LocalDate;

public class StudentClient {
  public static void main(String[] args) {
    Student student =
        Student.builder()
            .id("1")
            .name("Shantanu Kumar")
            .email("shan.raj93@gmail.com")
            .address("Yemlur")
            .birthday(LocalDate.of(2000, 11, 3))
            .build();

    System.out.println(student);
  }
}
