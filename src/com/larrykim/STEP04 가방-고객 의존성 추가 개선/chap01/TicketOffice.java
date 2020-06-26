package com.larrykim.chap01;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets=new ArrayList<>();

    public TicketOffice(Long amount, List<Ticket> tickets){
        this.amount=amount;
        this.tickets.addAll(tickets);
    }

    public Ticket getTicket(){
        return tickets.remove(0);
    }

    public void minusAmount(Long amount){
        this.amount-=amount;
    }

    public void plusAmount(Long amount){
        this.amount+=amount;
    }

    public Long getAmount(){
        return amount;
    }

    public int getTicketCount(){
        return tickets.size();
    }
}
