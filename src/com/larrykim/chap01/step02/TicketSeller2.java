package com.larrykim.chap01.step02;

public class TicketSeller2 {
    private TicketOffice2 ticketOffice;

    public TicketSeller2(TicketOffice2 ticketOffice){
        this.ticketOffice=ticketOffice;
    }

    public TicketOffice2 getTicketOffice() {
        return ticketOffice;
    }
}
