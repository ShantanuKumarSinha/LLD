package design.pattern.behavioural.adapter.TightCoupling;

public class YesBankAPI {
  public int getBalance() {
    return 1000;
  }

  public void moneyTransfer() {
    System.out.println("Money is transferred via Yes Bank!");
  }
}
