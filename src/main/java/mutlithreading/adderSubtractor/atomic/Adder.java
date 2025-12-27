package mutlithreading.adderSubtractor.atomic;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {

  ValueClass vclass;

  public Adder(ValueClass vclass) {
    this.vclass = vclass;
  }

  @Override
  public Void call() throws Exception {
    for (int i = 0; i < 10000; i++) {
      this.vclass.value.addAndGet(i);
    }
    return null;
  }
}
