package com.larrykim.chap01.step02;

public class Bag2 {
    private Long amount;
    private Invitation2 invitation;
    private Ticket2 ticket;

    public Bag2(Long amount){
        this(null, amount);
    }

    public Bag2(Invitation2 invitation, Long amount){
        this.invitation=invitation;
        this.amount=amount;
    }

    public boolean hasInvitation(){
        return invitation != null;
    }
    public boolean hasTicket(){
        return ticket != null;
    }
    public void setTicket(Ticket2 ticket){
        this.ticket = ticket;
    }
    public void minusAmount(Long amount){
        this.amount-=amount;
    }
    public void plusAmount(Long amount){
        this.amount+=amount;
    }

}
