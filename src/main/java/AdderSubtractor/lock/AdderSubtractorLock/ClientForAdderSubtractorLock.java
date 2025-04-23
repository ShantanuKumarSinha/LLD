package AdderSubtractor.lock.AdderSubtractorLock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClientForAdderSubtractorLock {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ValueClass valueClass = new ValueClass();
    Lock lock = new ReentrantLock();
    Adder adder = new Adder(valueClass, lock);
    Subtractor subtractor = new Subtractor(valueClass, lock);

    ExecutorService executorService = Executors.newFixedThreadPool(2);
    Future<Void> adderFuture = executorService.submit(adder);
    Future<Void> substractorFuture = executorService.submit(subtractor);

    adderFuture.get();
    substractorFuture.get();

    System.out.println(valueClass.value);

    executorService.shutdown();
  }
}
