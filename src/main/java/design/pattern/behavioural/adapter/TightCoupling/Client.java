package design.pattern.behavioural.adapter.TightCoupling;

public class Client {
  public static void main(String[] args) {
    PhonePay ph = new PhonePay();
    var loanEligiblity = ph.checkLoanEligiblity();
    System.out.println(loanEligiblity);
    ph.fastTagRecharge(500);
  }
}
