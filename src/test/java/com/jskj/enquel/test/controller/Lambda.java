package com.jskj.enquel.test.controller;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 一、Lambda 表达式基础语法：Java8引入了"->"（箭头操作符） 将lambda表达式拆成两部分：
 *      左侧：Lambda 表达式的参数列表
 *      右侧：Lambda 表达式中所需执行的功能 即lambda体
 *
 *      左右遇一括号省      ----- 1   ----- 2
 *      左侧推断类型省      ----- 3
 *
 * 语法格式一： 无参数 无返回值
 *      () -> System.out.println("Hello Lambda!");
 *
 * 语法格式二： 有一个参数 无返回值
 *         (x) -> System.out.println("x");
 *        （小括号可以省略不写）
 *         x -> System.out.println("x");                        ----- 1
 *
 * 语法格式三： 有两个以上参数 有返回值 并且lambda体中有多条语句
 *         Comparator<Integer> com = (x, y) -> {
 *             System.out.println("函数式接口");
 *             return Integer.compare(x, y);
 *         };
 *
 * 语法格式四： 有两个以上参数 有返回值 并且lambda体中只有有一条语句 return 及 {} 可以省略
 *      Comparator<Integer> com = (Integer x,Integer y) -> Integer.compare(x, y);       ----- 2
 *
 * 语法格式五： lambda表达式参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出数据类型，即"类型推断"
 *      (Integer x,Integer y) -> Integer.compare(x, y)
 *      (x,y) -> Integer.compare(x, y)                          ----- 3
 *
 *
 *
 *
 * 二、lambda表达式需要"函数是接口"支持
 *      函数式接口： 接口中只有一个抽象方法的接口； 可以使用注解 @FunctionalInterface 修饰 并进行检查是否为函数式接口
 */
public class Lambda {

    @Test
    public void test1(){
        // 原匿名方法
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world!");
            }
        };
        r.run();
        System.out.println("------------");
        // Lambda方式
        Runnable lambdaR = () -> System.out.println("hello world");
        lambdaR.run();
    }

    @Test
    public void test2(){
        Consumer<String> con = x -> System.out.println(x);
        con.accept("wo");

    }

    @Test
    public void test3(){
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    @Test
    public void test4(){
        Comparator<Integer> com = (Integer x,Integer y) -> Integer.compare(x, y);
    }


    // 需求： 对一个数进行运算
    public Integer operation(Integer num, MyFun mf) {
        return mf.getValue(num);
    }

    @Test
    public void twoLambdaTest1(){
        Integer num = operation(100, x -> x * x);
        System.out.println(num);
    }


}
