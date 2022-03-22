package com.alalili.java.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
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

        userList.stream().filter((user) -> user.getId() % 2 == 0)
        .sorted(Comparator.comparingInt(User::getId)).limit(1).forEach(System.out::println);
    }
}
