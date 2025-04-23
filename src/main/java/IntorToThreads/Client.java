package IntorToThreads;

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
      // if you can run directly it will execute on main thead
      // but our aim is to create new thread
      numberPrinter.run();
      thread.run();
      thread.start();
    }
    System.out.println(Thread.currentThread().getName() + ": I am Shantanu Kumar Sinha");
    System.out.println("Main thread end");
  }
}
