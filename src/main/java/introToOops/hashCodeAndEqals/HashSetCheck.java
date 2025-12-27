package introToOops.hashCodeAndEqals;

import java.util.HashSet;
import java.util.Set;

public class HashSetCheck {
  public static void main(String[] args) {
    Set<Employee> employeeSet = new HashSet<>();
    employeeSet.add(new Employee(1, "John"));
    employeeSet.add(new Employee(1, "John"));
    System.out.println("Size of employee set: " + employeeSet.size());
    System.out.println(employeeSet);
    System.out.println("If employee is found " + employeeSet.contains(new Employee(1, "John")));
  }
}
