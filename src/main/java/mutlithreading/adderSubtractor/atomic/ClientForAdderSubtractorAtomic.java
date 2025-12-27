package mutlithreading.adderSubtractor.atomic;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClientForAdderSubtractorAtomic {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    var valueClass = new ValueClass();
    var adder = new Adder(valueClass);
    var substractor = new Subtractor(valueClass);

    var executorService = Executors.newFixedThreadPool(2);
    Future<Void> adderFuture = executorService.submit(adder);
    Future<Void> substractorFuture = executorService.submit(substractor);

    adderFuture.get();
    substractorFuture.get();

    System.out.println(valueClass.value);

    executorService.shutdown();
  }
}
