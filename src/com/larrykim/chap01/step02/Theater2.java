package com.larrykim.chap01.step02;

import com.larrykim.chap01.step02.Audience2;

public class Theater2 {
    public TicketSeller2 ticketSeller;

    public Theater2(TicketSeller2 ticketSeller){
        this.ticketSeller=ticketSeller;
    }

    public void enter(Audience2 audience){
        if(audience.getBag().hasInvitation()) {
            Ticket2 ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket2 ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
