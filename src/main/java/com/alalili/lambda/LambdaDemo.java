package com.alalili.lambda;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaDemo {
    public static void main(String[] args) {
        //有参数没有返回值的写法，右侧为接口实现
        Consumer<String> consumer = (t) -> {
            System.out.println("没有返回值,有参数的的lambda表达式：输出为:" + t);
        };
        consumer.accept("Hello!");

        //没有参数，有返回值的写法
        Supplier<String> supplier = () -> UUID.randomUUID().toString();
        System.out.println(supplier.get());

        //有参数，有返回值
        Function<Integer, Integer> function = (t) -> t * 2;
        System.out.println(function.apply(6));

        //有参数，有返回值
        Predicate<String> predicate = (t) -> t.equals("f");
        predicate.test("aa");
    }
}
