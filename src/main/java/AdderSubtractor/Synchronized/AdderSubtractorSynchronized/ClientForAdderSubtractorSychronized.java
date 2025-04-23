package AdderSubtractor.Synchronized.AdderSubtractorSynchronized;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClientForAdderSubtractorSychronized {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ValueClass valueClass = new ValueClass();
    Adder adder = new Adder(valueClass);
    Subtractor subtractor = new Subtractor(valueClass);

    ExecutorService executorService = Executors.newFixedThreadPool(2);
    Future<Void> adderFuture = executorService.submit(adder);
    Future<Void> substractorFuture = executorService.submit(subtractor);

    adderFuture.get();
    substractorFuture.get();

    System.out.println(valueClass.value);

    executorService.shutdown();
  }
}
