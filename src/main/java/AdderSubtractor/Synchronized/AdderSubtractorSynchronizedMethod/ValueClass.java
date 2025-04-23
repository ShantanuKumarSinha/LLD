package AdderSubtractor.Synchronized.AdderSubtractorSynchronizedMethod;

public class ValueClass {
  public int value = 0;

  public synchronized void increment(int i) {
    this.value += i;
  }

  public synchronized void decrement(int i) {
    this.value -= i;
  }
}
