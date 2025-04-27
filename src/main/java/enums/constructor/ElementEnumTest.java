package enums.constructor;

import java.util.Arrays;

public class ElementEnumTest {
  public static void main(String[] args) {
    Arrays.stream(Element.values()).forEach(System.out::println);
    Arrays.stream(Element.values())
        .filter(ele -> ele.getName().equals("Nitrogen"))
        .findAny()
        .ifPresent(e -> System.out.println(e.getAtomicNumber()));
  }
}
