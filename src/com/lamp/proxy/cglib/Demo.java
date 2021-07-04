package com.lamp.proxy.cglib;


import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

class UserDao{

    void  save(){

        System.out.println("保存用户");
    }

}


class CglibProxy implements MethodInterceptor {
    Object targer;

     Object CreateProxy( Object   targer){
         this.targer=targer;
         Enhancer enhancer = new Enhancer();
         enhancer.setSuperclass(targer.getClass());
         enhancer.setCallback(this);
         Object o = enhancer.create();
         return o;
     }


     /*
     *  *proxy：代理对象

      *method：代理对象的方法，即增强过的方法

      *args[]：方法参数

      *methodProxy：代理对象方法的代理对象
     * */

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("增强");

       // Object invoke = methodProxy.invokeSuper(o, objects);
        Object invoke = method.invoke(targer,objects);
        return invoke;
    }
}



public class Demo {

    @Test
    public   void test(){
        UserDao userDao = new UserDao();
        CglibProxy cglibProxy = new CglibProxy();
        UserDao o = (UserDao)cglibProxy.CreateProxy(userDao);
        o.save();
    }
}
