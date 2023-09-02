package com.alalili.designpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
  * @description: 最优的创建单例模式的方式，并且高效的阻击了使用反射破解单例的情况
  * @author      LiBaoDeng
  * @datetime    2023/9/2 16:51
  * @version:    1.0
  */
public class EleganceSingleton {
    private EleganceSingleton() {
        //加入这个判断，防止反射暴力创建多个单例的实例
        if (null != EleganceSingletonHolder.SINGLETON) {
            throw new RuntimeException("不允许创建多个实例！");
        }
    }

    public static final EleganceSingleton getInstance() {
        return EleganceSingletonHolder.SINGLETON;
    }

    private static class EleganceSingletonHolder{
        private static final EleganceSingleton SINGLETON = new EleganceSingleton();
    }

    public static void main(String[] args) {
        //使用反射暴力破解单例模式测试
        try {
            Class<?> clazz = EleganceSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            Object c1 = c.newInstance();
            Object c2 = c.newInstance();
            System.out.println(c1 == c2);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
