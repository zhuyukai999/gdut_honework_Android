package com.zyk.experiment1.domain;

public class Fruit {
    private int Id;
    private String name;
    private String price;
    private String mprice;
    private String orginplace;
    private String descr;
    private String unit;

    public Fruit(){
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMprice() {
        return mprice;
    }

    public void setMprice(String mprice) {
        this.mprice = mprice;
    }

    public String getOrginplace() {
        return orginplace;
    }

    public void setOrginplace(String orginplace) {
        this.orginplace = orginplace;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
