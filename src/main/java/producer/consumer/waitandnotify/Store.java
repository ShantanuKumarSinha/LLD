package producer.consumer.waitandnotify;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {
  private Deque items;

  private int maxSize;

  public Store(int maxSize) {
    this.maxSize = maxSize;
    this.items = new ConcurrentLinkedDeque();
  }

  public Deque getItems() {
    return items;
  }

  public int getMaxSize() {
    return maxSize;
  }

  public void addItem(Object item){
    items.add(item);
  }

  public void removeItem(){
    items.remove();
  }


}
