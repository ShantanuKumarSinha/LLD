package generics;

public class Pair<V, S> {

  private V first;
  private S second;

  public Pair(V first, S second) {
    this.first = first;
    this.second = second;
  }

  public V getFirst() {
    return this.first;
  }

  public void setFirst(V first) {
    this.first = first;
  }

  public S getSecond() {
    return this.second;
  }

  public void setSecond(S second) {
    this.second = second;
  }

  public String toString() {
    return "(" + this.first + ", " + this.second + ")";
  }

  // this will give error because Class Bound Type initialization happens during run time
//  public static V checkStaticMethod(V v){
//    return v;
//  }

  public static <T> void checkStatic(T t){
    System.out.println(t);
  }


}
