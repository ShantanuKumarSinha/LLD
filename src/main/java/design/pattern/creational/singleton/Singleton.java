package design.pattern.creational.singleton;

public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {}

    // non compliant to sonar
    // more effective
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    public static synchronized Singleton getInstance(){
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
