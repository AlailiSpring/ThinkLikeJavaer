package com.alalili.java.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 注解处理器，没有这个，注解和注释没有多大区别了
 * 读取PasswordUtils工具类，并使用反射机制查找@UseCase注解
 * @Author: LiBaoDeng
 * @Date: 2021-01-31 23:35
 */
public class UsecaseTracker {
    public static void trackUseCase(List<Integer> useCases, Class<?> cls) {
        for (Method m : cls.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found useCase :" + uc.id() + " " + uc.descriprion());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (int i : useCases) {
            System.out.println("Warning:Missing use case-" + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCase(useCases, PasswordUtils.class);
    }
}
