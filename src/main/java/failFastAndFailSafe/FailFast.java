package failFastAndFailSafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Fail-Fast systems abort operation as-fast-as-possible exposing failures immediately and stopping
 * the whole operation. <br>
 * Fail-fast iterators in Java don’t play along when the underlying collection gets modified.<br>
 * <br>
 * Collections maintain an internal counter called modCount. Each time an item is added or removed
 * from the Collection, this counter gets incremented. <br>
 * <br>
 * When iterating, on each next() call, the current value of modCount gets compared with the initial
 * value. If there’s a mismatch, it throws ConcurrentModificationException which aborts the entire
 * operation.<br>
 * <br>
 * Default iterators for Collections from java.util package such as ArrayList, HashMap, etc. are
 * Fail-Fast.
 */
public class FailFast {
  public static void main(String[] args) {
    // ArrayList
    List<Integer> numberList = new ArrayList<>(List.of(1, 2, 4));
    var numIterator = numberList.iterator();
    // Adding something will throw ConcurrentModificationException
//        while (numIterator.hasNext()) {
//          var number = numIterator.next();
//          if (number == 2) numberList.add(3);
//          System.out.println(number);
//        }
    // Calling remove method of iterator will not throw ConcurrentModificationException
    var numberIterator = numberList.iterator();
    while (numberIterator.hasNext()) {
      var number = numberIterator.next();
      if (number == 2) {
        numberIterator.remove();
        // If we call remove method again without calling next() it will throw IllegalStateException
        //numberIterator.remove();
      }
      System.out.println(number);
    }
    // Calling remove of Collection will throw ConcurrentModificationException
    var anotherIterator = numberList.iterator();
    while (anotherIterator.hasNext()) {
      var number = anotherIterator.next();
      if (number == 4) numberList.remove(number);
    }
  }
}
