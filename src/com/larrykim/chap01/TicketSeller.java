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

}
