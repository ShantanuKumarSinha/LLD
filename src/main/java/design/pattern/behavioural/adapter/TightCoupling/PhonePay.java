package design.pattern.behavioural.adapter.TightCoupling;

public class PhonePay {

  YesBankAPI yb = new YesBankAPI();
  PhonePeLoan pl = new PhonePeLoan();
  FastTagRecharge ft = new FastTagRecharge();

  boolean checkLoanEligiblity() {
    return pl.loanCheck(yb);
  }

  boolean fastTagRecharge(int amount) {
    if (ft.recharge(yb, amount) >= 0) {
      System.out.println("Recharge successful");
      return true;
    }
    return false;
  }
}
