package enums.constructor;

public enum Element {
  H("Hydrogen", 1),
  He("Helium", 2),
  Li("Lithium", 3),
  Be("Beryllium", 4),
  B("Bronze", 5),
  C("Carbon", 6),
  N("Nitrogen", 7);


  private String name;
  private Integer atomicNumber;

  private Element(String name, Integer atomicNumber) {
    this.name = name;
    this.atomicNumber = atomicNumber;
  }

  public String getName() {
    return name;
  }

  public Integer getAtomicNumber() {
    return atomicNumber;
  }
}
