package com.lamp.ocp;

public class TestOcp {
    public static void main(String[] args) {
        HuaWeiComputer huawei = new HuaWeiComputer("huawei", 1, 4000);
        System.out.println(huawei.getPrice());
        LenovoComputer legion = new LenovoComputer("legion", 2, 4100);
        System.out.println(legion.getPrice());

        /*
        * 有点:新增业务类不改定之前的代码
        * 确定:会引起类的扩张
        * */
        LenovoDiscount lenovoDiscount = new LenovoDiscount("xiaoxin",2,4200,0.5F);
        System.out.println(lenovoDiscount.getDiscount());


    }
}
