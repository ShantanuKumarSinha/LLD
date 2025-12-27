package introToOops.inheritence;

import java.util.ArrayList;
import java.util.List;

public class B extends A {
  static int test = 10;
  int z;

  public B() {}

  public B(int x, int y, int z) {
    super(x, y);
    this.z = z;
  }

  public static void testStatic() {
    System.out.println("testStatic invoked from B");
  }

  public static void main(String[] args) {
    B b = new B(1, 2, 3);
    System.out.println(test);
    System.out.println(A.test);
    List<Integer> list  = new ArrayList<>();
    list.addLast(1);

    A.testStatic();
    B.testStatic();
  }
}
