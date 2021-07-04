package com.lamp.Strategy;


/**
 * 策略模式
 * 定义一系列的算法,把每一个算法封装起来, 并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化
 */


import org.junit.Test;

interface Travel {
    void transport();
}


class Bycycle implements Travel {


    @Override
    public void transport() {
        System.out.println("自行车");
    }
}

class Car implements Travel {


    @Override
    public void transport() {
        System.out.println("汽车");
    }
}

class SelecetOne {
    private Travel travel;

    public SelecetOne(Travel travel) {
        this.travel = travel;
    }

    public void Travelgo() {
        travel.transport();
    }

    /*中途改变交通工具*/


    public void setTravel(Travel travel) {
        this.travel = travel;
    }
}

public class Demo {

    @Test
    public void test_() {

        SelecetOne selecetOne = new SelecetOne(new Bycycle());
        selecetOne.setTravel(new Car());
        selecetOne.Travelgo();


    }
}
