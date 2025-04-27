package design.pattern.behavioural.adapter.TightCoupling;

public class FastTagRecharge {
  public int recharge(YesBankAPI yb, int amount) {
    if (yb.getBalance() >= amount) {
      return 1;
    }

    return 0;
  }
}
