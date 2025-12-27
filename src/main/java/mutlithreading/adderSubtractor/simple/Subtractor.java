package mutlithreading.adderSubtractor.simple;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {

  ValueClass vclass;

  public Subtractor(ValueClass vclass) {
    this.vclass = vclass;
  }

  @Override
  public Void call() throws Exception {
    for (int i = 0; i < 10000; i++) {
      this.vclass.value -= i;
    }
    return null;
  }
}
