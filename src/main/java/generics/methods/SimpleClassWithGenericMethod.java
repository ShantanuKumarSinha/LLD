package generics.methods;

import java.util.List;

public class SimpleClassWithGenericMethod {

  public static void main(String[] args) {
    SimpleClassWithGenericMethod simpleClassWithGenericMethod = new SimpleClassWithGenericMethod();
    var list = List.of("a", "b", "c");
    var name = "simpleClassWithGenericMethod";
    var list2 = List.of(1, 2, 3);
    simpleClassWithGenericMethod.simpleMethod(list);
    simpleClassWithGenericMethod.anotherMethod(list, name);
    simpleClassWithGenericMethod.thirdMethod(list, list2);
    var list3 = List.of(1.0, 2.0, 3.0);
    staticMethod(list,list2,list3);
  }

  public <T> void simpleMethod(List<T> list) {
    list.forEach(System.out::print);
    System.out.println();
  }

  public <Q> void anotherMethod(List<Q> list, String name) {
    list.forEach(System.out::print);
    System.out.println();
    System.out.print(name);
    System.out.println();
  }

  public <Q, R> void thirdMethod(List<Q> list, List<R> list2) {
    list.forEach(System.out::print);
    System.out.println();
    list2.forEach(System.out::print);
  }

  public static <Q, R, S> void staticMethod(List<Q> list, List<R> list2, List<S> list3) {
    list.forEach(System.out::print);
    System.out.println();
    list2.forEach(System.out::print);
    System.out.println();
    list3.forEach(System.out::print);
  }
}
