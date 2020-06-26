package com.larrykim.chap01;

import com.larrykim.chap01.Audience;

public class Theater {
    public TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller){
        this.ticketSeller=ticketSeller;
    }

    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            System.out.println("1 고객이 초대장이 있네요.");
            System.out.println("1 티켓오피스에서 티켓을 가져와 고객 가방에 넣어줍니다.");
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            System.out.println("2 고객이 초대장이 없네요.");
            System.out.println("2 고객의 가방에서 돈을 꺼내, 티켓오피스에서 티켓을 사서 고객 가방에 넣어줍니다.");
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }

}
