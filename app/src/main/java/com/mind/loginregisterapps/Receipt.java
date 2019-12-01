package com.mind.loginregisterapps;

public class Receipt {

    int rno;
int amount;


    String destination;



    public Receipt(int rno, int amount, String destination) {
        this.rno = rno;
        this.amount = amount;
        this.destination = destination;
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }




}
