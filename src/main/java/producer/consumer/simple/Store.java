package producer.consumer.simple;

import java.util.ArrayList;
import java.util.List;

public class Store {
  private int maxSize;
  private List<Object> items;

  public Store(int maxSize) {
    this.maxSize = maxSize;
    this.items = new ArrayList<>();
  }

  public List<Object> getItems() {
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
