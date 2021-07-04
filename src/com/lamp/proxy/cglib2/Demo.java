package com.lamp.proxy.cglib2;


import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import javax.swing.plaf.PanelUI;
import java.lang.reflect.Method;

class  service{
    public   void  Save(){

        System.out.println("service.Save");
        
    }
}





class proxy implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("代理对象啦");
        methodProxy.invokeSuper(o,objects);
        return null;
    }
}


public class Demo {
    
    
    @Test
    public void Test(){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(service.class);
        enhancer.setCallback(new proxy());
        service  o = (service)enhancer.create();
        o.Save();
    }
}
