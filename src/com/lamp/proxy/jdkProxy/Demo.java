package com.lamp.proxy.jdkProxy;

/*
 * jdk 动态代理
 * */

import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

interface Action {
    void save();
    void sayHi();


}


class ItemObject implements Action {
    @Override
    public void save() {
        System.out.println(" 持久化");
        sayHi();
    }
    @Override
    public  void sayHi() {
        System.out.println("ItemObject.sayHi");
    }
}


class ProxyJdk implements InvocationHandler {

    Object object;

    public ProxyJdk(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理对象------------------");
        method.invoke(object, args);
        return null;
    }
}


public class Demo {

    @Test
    public void Test() throws IOException {
        ItemObject itemObject = new ItemObject();

        ProxyJdk proxyJdk = new ProxyJdk(itemObject);

        Action action = (Action) Proxy.newProxyInstance(itemObject.getClass().getClassLoader(), itemObject.getClass().getInterfaces(), proxyJdk);
        action.save();
        action.sayHi();


        /*int accessFlags = Modifier.PUBLIC | Modifier.FINAL;
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                "proxyName", itemObject.getClass().getInterfaces(), accessFlags);


        OutputStream outputStream = new FileOutputStream(new File("F:\\myEnvforJava\\pattern\\a.class"));
        outputStream.write(proxyClassFile);*/


    }
}

