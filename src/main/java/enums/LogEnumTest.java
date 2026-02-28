package enums;

public class LogEnumTest {
  public static void main(String[] args) {
    LogEnum logEnum = LogEnum.valueOf("Info");

    System.out.println(logEnum.name()+ " and " + logEnum.ordinal());
  }
}
