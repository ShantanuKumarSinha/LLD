package producer.consumer.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {
  private int maxSize;
  private ConcurrentLinkedDeque<Object> items;

  public Store(int maxSize) {
    this.maxSize = maxSize;
    this.items = new ConcurrentLinkedDeque<>();
  }

  public ConcurrentLinkedDeque<Object> getItems() {
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
    items.remove(items.size() - 1);
  }
}
