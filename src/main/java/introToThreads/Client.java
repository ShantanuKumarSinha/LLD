package introToThreads;

public class Client {
  public static void main(String[] args) throws InterruptedException {
    HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
    //    Thread thread = new Thread(helloWorldPrinter);
    //    thread.start();

    //    helloWorldPrinter.run();

    //    for (int i = 1; i <= 1000; i++) {
    //     // Thread.sleep(200);
    //      Thread thread = new Thread(helloWorldPrinter);
    //      thread.start();
    //    }

    for (int i = 1; i <= 1000; i++) {
      NumberPrinter numberPrinter = new NumberPrinter(i);
      Thread thread = new Thread(numberPrinter);
      /*  If you run directly, it will execute on the main thread, but our aim is to create new thread
          Always use start() to start a new thread otherwise it will run on the main thread as we saw below
      */

      // numberPrinter.run();
      // thread.run();
        
      thread.start();
    }
    System.out.println(Thread.currentThread().getName() + ": I am Shantanu Kumar Sinha");
    System.out.println("Main thread end");
  }
}
