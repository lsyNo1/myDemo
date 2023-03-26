package designPattern.src.main.java.com.lsy.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by lance on 2023/3/26.
 * 枚举单例
 * 可以防范反射，因为构造器的newInstance进行了枚举的判断
 */
public enum EnumSingleton {

    INSTANCE;

    public EnumSingleton getInstance() {
        return INSTANCE;
    }

}


class testEnumSingleton {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<EnumSingleton> enumSingletonClass = EnumSingleton.class;

        // 枚举类默认继承 enum 类，父类的构造器是两个参数，string和int
        Constructor<EnumSingleton> constructors = enumSingletonClass.getDeclaredConstructor(String.class, int.class);
        constructors.setAccessible(true);

        EnumSingleton enumSingleton1 = constructors.newInstance();
        EnumSingleton enumSingleton2 = constructors.newInstance();

        System.out.println(enumSingleton1);
        System.out.println(enumSingleton2);
    }

}
