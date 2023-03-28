package com.lsy.classLoader;

/**
 * Created by lance on 2023/3/27.
 * 类加载器
 * 核心知识点：双亲委派机制, 加在类时，会向上委托加载，父类没有才会向下加载
 * 三层类加载器：AppClassLoader -> ExtClassLoader -> BootStrapClassLoader
 */
public class UseClassLoader {
    private String name;

    public static void main(String[] args) {

        UseClassLoader useClassLoader = new UseClassLoader();

        Class<? extends UseClassLoader> classLoaderClass = useClassLoader.getClass();
        System.out.println(useClassLoader.getClass());
        System.out.println(classLoaderClass.getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoaderClass.getClassLoader().getParent());//sun.misc.Launcher$ExtClassLoader@29453f44
        System.out.println(classLoaderClass.getClassLoader().getParent().getParent());//null,获取不到，是用C++写的底层
    }
}
