package com.larrykim.chap01;

public class Ticket {
    private Long fee;
    private String title;
    public Long getFee(){
        return this.fee;
    }
    public void setFee(Long fee) {this.fee=fee;}
    public void setTitle(String title){this.title=title;}
}
