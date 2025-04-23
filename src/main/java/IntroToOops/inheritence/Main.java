package IntroToOops.inheritence;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello, World!");
    A a = new B(1, 2, 3);
    B b = (B) a;
    System.out.println(b.z);
  }
}
