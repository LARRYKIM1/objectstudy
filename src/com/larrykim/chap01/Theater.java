package com.larrykim.chap01;

import com.larrykim.chap01.Audience;

public class Theater {
    public TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller){
        this.ticketSeller=ticketSeller;
    }

    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }

}
