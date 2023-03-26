package designPattern.src.main.java.com.lsy.singleton;

/**
 * Created by lance on 2023/3/26.
 * 静态内部类单例模式
 */
public class StaticInnerClass {

    private StaticInnerClass() {
    }

    private static class innerClass {
        private final static StaticInnerClass staticInnerClass = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance() {
        return innerClass.staticInnerClass;
    }

}
