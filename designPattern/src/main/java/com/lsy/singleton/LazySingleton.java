package designPattern.src.main.java.com.lsy.singleton;

/**
 * Created by lance on 2023/3/25.
 */
public class LazySingleton {

    private LazySingleton() {
    }

    private static LazySingleton lazySingleton;


    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }


}
