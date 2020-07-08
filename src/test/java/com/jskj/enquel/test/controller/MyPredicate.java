package com.jskj.enquel.test.controller;

@FunctionalInterface
public interface MyPredicate<T> {

    public boolean myFilter(T t);

}
