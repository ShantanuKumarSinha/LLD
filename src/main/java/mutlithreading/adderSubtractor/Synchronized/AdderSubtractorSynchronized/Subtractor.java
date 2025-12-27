package mutlithreading.adderSubtractor.Synchronized.AdderSubtractorSynchronized;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {

  ValueClass vclass;

  public Subtractor(ValueClass vclass) {
    this.vclass = vclass;
  }

  @Override
  public Void call() throws Exception {
    for (int i = 0; i < 100000; i++) {
      synchronized (this.vclass) {
        System.out.println("Subtractor: " + i);
        this.vclass.value -= i;
      }
    }
    return null;
  }
}
