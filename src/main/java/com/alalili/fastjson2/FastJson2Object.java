package com.alalili.fastjson2;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;

import java.util.List;

public class FastJson2Object {
    public static void main(String[] args) {
        String str = "[{\"name\":\"John\",\"age\":30},{\"name\":\"Mary\",\"age\":25}]";

        // 将字符串转换为List<Person>对象
        TypeReference<List<Person>> reference = new TypeReference<List<Person>>() {};
        List<Person> persons = JSON.parseObject(str, reference);

        // 遍历List<Person>对象并输出每个元素的属性
        for (Person person : persons) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }
    }
}
