package designPattern.src.main.java.com.lsy.singleton;

import java.util.concurrent.TimeUnit;

/**
 * Created by lance on 2023/3/25.
 * 双重锁懒汉式单例（DCL）
 * 可以解决：普通懒汉式单例的线程不安全
 * 存在问题：无法防范反射
 */
public class SynchronizedLazySingleton {

    private SynchronizedLazySingleton() {

    }

    /**
     * 需要添加volatile 关键字，目的是防止实例化的时候指令重排序
     */
    private volatile static SynchronizedLazySingleton lazySingleton;

    public static SynchronizedLazySingleton getInstance() {
        if (lazySingleton == null) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // synchronized 修饰代码块，最小化锁的影响
            synchronized (SynchronizedLazySingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new SynchronizedLazySingleton();// 这个工作不是原子性操作，会发生指令重排
                }
            }
        }
        return lazySingleton;
    }
}

class testSynchronizedLazySingleton {
    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            new Thread(() -> {
                SynchronizedLazySingleton instance = SynchronizedLazySingleton.getInstance();
                System.out.println(instance);
            }).start();
        }

    }
}