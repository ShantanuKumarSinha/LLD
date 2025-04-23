package AdderSubtractor.lock.AdderSubtractorLock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {

  ValueClass vclass;
  Lock lock;

  public Subtractor(ValueClass vclass, Lock lock) {
    this.vclass = vclass;
    this.lock = lock;
  }

  @Override
  public Void call() throws Exception {
    lock.lock();
    for (int i = 0; i < 100000; i++) {
      this.vclass.value -= i;
    }
    lock.unlock();
    return null;
  }
}
