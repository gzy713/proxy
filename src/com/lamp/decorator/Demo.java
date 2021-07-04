package com.lamp.decorator;


import org.junit.Test;

/**
 * 装饰着模式的意义是 让被装饰的类更加强大
 * 代理模式的意义是--- 对被调用者屏蔽真实的对象
 */


interface Action {
    void dance();

}


class CommmonAction implements Action {



    @Override
    public void dance() {
        System.out.println("danceing--------------");
    }
}

class Decotator implements Action {

    Action action;

    public Decotator(Action action) {
        this.action = action;
    }

    @Override
    public void dance() {

        System.out.println("make up");
        action.dance();
        ;
    }
}


public class Demo {
    @Test
    public void test() {
        Action action = new CommmonAction();
//        action.dance();
//        ;

        Action commmonAction = new Decotator(action);
        commmonAction.dance();
        ;


    }
}
