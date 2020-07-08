package com.jskj.enquel.test.controller;

import com.jskj.enquel.entity.UserDTO;
import org.junit.Test;

import java.util.*;

public class Java8Test {


    // 原来匿名内部类 比较大小
    @Test
    public void test1(){
        Comparator<Integer> com = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }
    // Lambda 表达式
    @Test
    public void lambdaTest1(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }


    // 获取当前公司中员工年龄大于 35 的员工信息
    List<Employee> employees = Arrays.asList(
        new Employee("a",7),
        new Employee("bb",22),
        new Employee("ccc",111),
        new Employee("dddd",36)
    );

    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp){
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (mp.myFilter(employee)){
                emps.add(employee);
            }
        }
        return emps;
    }
    @Test
    public void lambdaTest2() {
        List<Employee> emplList = filterEmployee(employees, (e) -> e.getAge() >= 35);
        emplList.forEach(System.out::println);
    }

    @Test
    public void streamTest2(){
        employees.stream()
            .filter((e) -> e.getAge() >= 35)
            .limit(1)
            .forEach(System.out::println);
    }



}
