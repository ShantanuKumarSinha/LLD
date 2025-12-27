package enums.constructor;

import java.util.Arrays;

public class ElementEnumTest {
  public static void main(String[] args) {
    System.out.println("Elements in the periodic table:");
    Arrays.stream(Element.values())
        .forEach(
            element -> {
              System.out.println(
                  "Element symbol "
                      + element.name()
                      + " represents "
                      + element.getName()
                      + " atomic value "
                      + element.getAtomicNumber());
            });
    // Find the atomic number of Nitrogen
    System.out.println("Atomic number of Nitrogen:");
    Arrays.stream(Element.values())
        .filter(ele -> ele.getName().equals("Nitrogen"))
        .findAny()
        .ifPresent(e -> System.out.println(e.getAtomicNumber()));
    // In enum values of or enum object name() method will represent you EnumConstants
    System.out.println("Element Hydrogen atomic number :" + Element.valueOf("H").getAtomicNumber());
  }
}
