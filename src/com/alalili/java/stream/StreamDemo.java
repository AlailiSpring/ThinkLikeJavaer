package com.alalili.java.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: JDK1.8 Stream的写法
 * @Author: LiBaoDeng
 * @Date: 2022-03-22 23:19
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(20, "XiaoHei", "Male"));
        userList.add(new User(30, "XiaoHong", "Female"));
        userList.add(new User(40, "Dean", "Male"));
        userList.stream().forEach((t)-> System.out.println(t));

        System.out.println("--------------");

        //stream过滤，不会改变原有元素
        userList.stream().filter((user) -> user.getId() % 2 == 0)
        .sorted(Comparator.comparingInt(User::getId)).limit(1).forEach(System.out::println);

        //stream筛选元素进行赋值,根据Collectors可以设置不同的容器类型
        List<User> users=userList.stream().filter((user) -> user.getId() % 2 == 0)
                .sorted(Comparator.comparingInt(User::getId)).limit(1).collect(Collectors.toList());

        //数据转换的玩法,条件筛选符合条件的User ID 列表
        List<Integer> idList = userList.stream().map(User::getId).collect(Collectors.toList());

        //根据sex进行分组
        Map<String, List<User>> sexMap = userList.stream().collect(Collectors.groupingBy(User::getSex));
        Iterator<Map.Entry<String, List<User>>> iterator = sexMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<User>> next = iterator.next();
            System.out.println("key is:" + next.getKey());
            System.out.println("Value is" + next.getValue());
        }
    }
}
