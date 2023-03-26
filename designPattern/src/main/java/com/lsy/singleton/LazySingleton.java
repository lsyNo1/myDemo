package designPattern.src.main.java.com.lsy.singleton;

import java.util.concurrent.TimeUnit;

/**
 * Created by lance on 2023/3/25.
 * 基础的懒汉式单例
 * 问题：线程不安全,多线程下会额外实例化
 */
public class LazySingleton {

    private LazySingleton() {
    }

    private static LazySingleton lazySingleton;


    public static LazySingleton getInstance() throws InterruptedException {
        if (lazySingleton == null) {
            TimeUnit.SECONDS.sleep(2);
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}

class test {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            new Thread(() -> {
                LazySingleton lazySingleton = null;
                try {
                    lazySingleton = LazySingleton.getInstance();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(lazySingleton);
            }).start();
        }
    }
}
