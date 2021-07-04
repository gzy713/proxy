package com.lamp.proxy.StaticProxy;


import org.junit.Test;

interface Action {
    void save();
}


class ItemClass implements Action {

    @Override
    public void save() {
        System.out.println("目标类");
    }
}


class proxyClass implements Action {
    Action action;


    public proxyClass() {
        this.action = new ItemClass();
    }

    @Override
    public void save() {
        System.out.println("log4j---------------------");
        action.save();
        System.out.println("log4j---------------------");

    }
}


public class Demo {
    @Test
    public void testProxy() {
        proxyClass proxyClass = new proxyClass();
        proxyClass.save();

    }
}