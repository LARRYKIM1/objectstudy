package com.larrykim.chap01.step02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice2 {
    private Long amount;
    private List<Ticket2> tickets=new ArrayList<>();

    public TicketOffice2(Long amount, Ticket2... tickets){
        this.amount=amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public Ticket2 getTicket(){
        return tickets.remove(0);
    }

    public void minusAmount(Long amount){
        this.amount-=amount;
    }

    public void plusAmount(Long amount){
        this.amount+=amount;
    }
}
