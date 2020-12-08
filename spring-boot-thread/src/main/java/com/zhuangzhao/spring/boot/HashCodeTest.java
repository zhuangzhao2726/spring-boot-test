package com.zhuangzhao.spring.boot;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-01-07 21:07
 */
public class HashCodeTest {


    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();

        System.out.println(list.hashCode());

        list.add(1);
        System.out.println(list.hashCode());

        list.add(1);
        System.out.println(list.hashCode());


        list.add(1);
        System.out.println(list.hashCode());

        list.add(1);
        System.out.println(list.hashCode());


        list.add(1);
        System.out.println(list.hashCode());


        System.out.println("---------------------");

        Node node = new Node();
        System.out.println(node.hashCode());


        node.name = "123456";
        System.out.println(node.hashCode());


        node.name = "123456345678";
        System.out.println(node.hashCode());



        node.name = "123wertyui76456";
        System.out.println(node.hashCode());


        node.name = "";
        System.out.println(node.hashCode());


    }
}


class Node {
    String name;

    int val;
}