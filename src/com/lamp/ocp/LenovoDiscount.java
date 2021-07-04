package com.lamp.ocp;

public class LenovoDiscount  extends  LenovoComputer{
    private  float discount;
    public LenovoDiscount(String name, Integer id, Integer price,float discount) {
        super(name, id, price);
        this.discount=discount;
    }
    public float getDiscount(){
        return getPrice()*this.discount;
    }
}
