package introToOops.hashCodeAndEqals;

import java.util.Objects;

public class Employee {
  private int id;
  private String name;

  public Employee(int id, String name) {
    this.id = id;
    this.name = name;
  }

  // The default implementation of equals() in the Object class compares the identity of the object.
  // which means by default equals() method will do shallow copy, which means this==obj is checked.
  // We do need to override equals method if we want to  compare two object is equals or not.
@Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || !(o instanceof Employee)) return false;
    var employee = (Employee) o;
    boolean nameEquals =
        (this.name == null && employee.name == null)
            || (this.name != null && this.name.equals(employee.name));
    return this.id == employee.id && nameEquals;
  }

  // hascode is supposed to have
  // internal consistency which means value of hashcode changes with change in the value of property
  // in equals
  // external consistency means if two objects are equal they have same hash code
  // collision two unequal objects can have same hash code

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}
