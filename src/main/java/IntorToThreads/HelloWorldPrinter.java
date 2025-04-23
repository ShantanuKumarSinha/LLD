package IntorToThreads;

public class HelloWorldPrinter implements Runnable {


    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
      throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" : Hello World!");
    }
}
