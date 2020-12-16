package com.kuang.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 题目要求：一分钟完成此题，只能用一行代码实现
 * 现在有五个用户，筛选
 * 1.ID必须是偶数
 * 2.年龄必须大于23岁
 * 3.用户名转化成大写字母
 * 4.用户名字母倒着排序
 * 5.只输出一个用户
 */
public class Tset {
    public static void main(String[] args) {
        User u1=new User(1,21,"a");
        User u2=new User(2,22,"b");
        User u3=new User(3,23,"c");
        User u4=new User(4,24,"d");
        User u5=new User(5,25,"e");

        List<User> list= Arrays.asList(u1,u2,u3,u4,u5);

        list.stream().filter(u->{return u.getId()%2==0;})
                .filter(u->{return u.getAge()>23;})
                .map(u->{return u.getName().toUpperCase();})
                .sorted((uu1,uu2)->{return uu2.compareTo(uu1);})
                .limit(1)
                .forEach(System.out::println);
    }
}
