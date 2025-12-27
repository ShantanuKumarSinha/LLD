package immutableClass;

import java.util.Objects;

/**
 * An immutable class representing an Employee with id, name, salary, and address. The Address class
 * is assumed to be a separate mutable class with appropriate getters. To maintain immutability,
 * defensive copies of mutable objects are created in the constructor and getter methods.
 */
public final class EmployeeImmutableClass {
  private final int id;
  private final String name;
  private final double salary;
  private final Address address;

  public EmployeeImmutableClass(int id, String name, double salary, Address address) {
    this.id = id;
    this.name = Objects.requireNonNull(name, "Name cannot be null");
    this.salary = salary;
    Objects.requireNonNull(address, "Address cannot be null");
    this.address =
        new Address(
            address.getBuildingName(),
            address.getStreet(),
            address.getLandMark(),
            address.getCity(),
            address.getState(),
            address.getCountry(),
            address.getPinCode());
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return this.name;
  }

  public double getSalary() {
    return salary;
  }

  public Address getAddress() {
    return new Address(
        address.getBuildingName(),
        address.getStreet(),
        address.getLandMark(),
        address.getCity(),
        address.getState(),
        address.getCountry(),
        address.getPinCode());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || !(o instanceof EmployeeImmutableClass)) return false;
    EmployeeImmutableClass emp = (EmployeeImmutableClass) o;
    return this.id == emp.getId()
        && Double.compare(this.getSalary(), emp.getSalary()) == 0
        && Objects.equals(this.getName(), emp.getName())
        && Objects.equals(this.address, emp.getAddress());
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, Double.valueOf(salary), address);
  }

  @Override
  public String toString() {
    return "EmployeeImmutableClass{id = " + id + ", name = " + name + ", salary = " + salary + "}";
  }
}
