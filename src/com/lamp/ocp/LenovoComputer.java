package com.lamp.ocp;

public class LenovoComputer implements  Computer {
    private  String name;
    private Integer id;
    private  Integer price;
    public LenovoComputer(String name, Integer id, Integer price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }


    @Override
    public String toString() {
        return "LenovoComputer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                '}';
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
