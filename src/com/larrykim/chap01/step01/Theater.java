package com.larrykim.chap01.step01;

public class Theater {
    public TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller){
        this.ticketSeller=ticketSeller;
    }

    public void enter(Audience audience){

        //문제: Theater가 관람객의 가방
        if(audience.getBag().hasInvitation()) {
            //문제: 판매원의 매표소에 직접 접근
            //직접 접근한다는 것은 Theater가 Audience와 Ticketseller에 결합력이 높아진다는 의미.
            System.out.println("초대장이 있네요...");
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            System.out.println("고객 가방에 티켓을 직접 넣어줍니다...");
            audience.getBag().setTicket(ticket);
        } else {
            System.out.println("초대장이 없네요...");
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            System.out.println("고객 가방에 티켓을 직접 넣어줍니다...");
            audience.getBag().setTicket(ticket);
        }
    }
}
