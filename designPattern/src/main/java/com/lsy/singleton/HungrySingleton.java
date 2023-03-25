package designPattern.src.main.java.com.lsy.singleton;

/**
 * Created by lance on 2023/3/25.
 */
public class HungrySingleton {

    private HungrySingleton() {
    }

    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }


}
