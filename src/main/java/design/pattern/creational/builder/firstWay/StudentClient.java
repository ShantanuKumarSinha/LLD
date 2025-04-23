package design.pattern.creational.builder.firstWay;

public class StudentClient {
  public static void main(String[] args) {
    var student =
        Student.builder()
            .id(1)
            .name("Test")
            .address("Bangarpete")
            .email("test@test.com")
            .phone("9743214545")
            .build();

    System.out.println(student);
  }
}
