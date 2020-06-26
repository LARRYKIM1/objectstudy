package com.larrykim.chap01;

import com.larrykim.chap01.Audience;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice=ticketOffice;
    }

    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }

    public void sellTo(Audience audience) {
//        System.out.println("Before");
//        System.out.println("보유티켓수 = "+ticketOffice.getTicketCount());
//        System.out.println("보유금액 = "+ticketOffice.getAmount());

        System.out.println("=============");
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
        System.out.println("=============");

//        System.out.println("After");
//        System.out.println("보유티켓수 = "+ticketOffice.getTicketCount());
//        System.out.println("보유금액 = "+ticketOffice.getAmount());
    }
}
