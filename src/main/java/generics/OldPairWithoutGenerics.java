package generics;

public class OldPairWithoutGenerics {
  private Object first;
  private Object second;

  public OldPairWithoutGenerics(Object first, Object second) {
    this.first = first;
    this.second = second;
  }

  public Object getFirst() {
    return first;
  }

  public void setFirst(Object first) {
    this.first = first;
  }

  public Object getSecond() {
    return second;
  }

  public void setSecond(Object second) {
    this.second = second;
  }
}
