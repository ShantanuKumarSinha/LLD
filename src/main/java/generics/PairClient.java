package generics;

import java.util.ArrayList;
import java.util.List;

public class PairClient {
  public static void main(String[] args) {
    Pair<Double, Double> coOrdinate = new Pair<>(3.0, 4.0);

    List list = new ArrayList();
    list.add(coOrdinate);
    list.add(coOrdinate);
    list.add(coOrdinate);
    System.out.println(list);

    Pair.checkStatic(coOrdinate);
  }
}
