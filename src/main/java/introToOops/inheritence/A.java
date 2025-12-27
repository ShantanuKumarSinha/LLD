package introToOops.inheritence;

public class A {
    int x;
    int y;
    static int test =5;
    private int d;

    public A() {

    }

    public A(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void testStatic() {
        System.out.println("testStatic invoked from A");
    }
}
