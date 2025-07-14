package producer.consumer.semaphore;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Store class represents a shared resource in the producer-consumer problem. It maintains a maximum
 * size and allows items to be added or removed. The items are stored in a thread-safe deque.
 */
public class Store {

  private final int maxSize;
  // Using Deque to allow both ends to be accessed
  private final Deque<Object> items;

  /** Using ConcurrentLinkedDeque for thread-safe operations
   * This allows multiple producers and consumers to operate on the store
   * without explicit synchronization, as it handles concurrent access internally.
   * Using ConcurrentLinkedDeque for thread-safe operations
   * Collections like ArrayList are not thread-safe
   * and can lead to concurrency issues in a producer-consumer scenario.
   * ConcurrentLinkedDeque allows concurrent access and modifications
   */
  public Store(int maxSize) {
    this.maxSize = maxSize;
    this.items = new ConcurrentLinkedDeque<>();
  }

  public Deque<Object> getItems() {
    return items;
  }

  public int getMaxSize() {
    return maxSize;
  }

  public void addItem() {
    System.out.println("Producer production time, current size " + this.items.size());
    items.add(new Object());
  }

  public void removeItem() {
    System.out.println("Consumer consumption time, current size " + this.items.size());
    items.remove();
  }
}
