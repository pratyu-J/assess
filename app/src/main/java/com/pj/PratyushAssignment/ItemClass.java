package com.pj.PratyushAssignment;

public class ItemClass {
    String name;
    String price;
    String rank;
    String date;
    String status;

    public ItemClass(){

    }

    public ItemClass(String name, String price, String rank, String date, String status){
        this.name  = name;
        this.price = price;
        this.rank = rank;
        this.date = date;
        this.status = status;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
