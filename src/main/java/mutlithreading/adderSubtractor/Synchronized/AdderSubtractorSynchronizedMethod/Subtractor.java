package mutlithreading.adderSubtractor.Synchronized.AdderSubtractorSynchronizedMethod;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {

  ValueClass vclass;

  public Subtractor(ValueClass vclass) {
    this.vclass = vclass;
  }

  @Override
  public Void call() throws Exception {
    for (int i = 0; i < 100000; i++) {
      this.vclass.decrement(i);
    }
    return null;
  }
}
