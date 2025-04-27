package design.pattern.behavioural.adapter.TightCoupling;

public class PhonePeLoan {
  public boolean loanCheck(YesBankAPI yb) {
    if (yb.getBalance() > 100) {
      return true;
    }

    return false;
  }
}
