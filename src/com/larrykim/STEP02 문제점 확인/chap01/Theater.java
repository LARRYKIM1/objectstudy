package com.larrykim.chap01;

import com.larrykim.chap01.Audience;

public class Theater {
    public TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller){
        this.ticketSeller=ticketSeller;
    }

    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) { // 문제점: 고객 가방에서 초대장 직접 확인 하네... 고객이 하게 해줘도 될텐데...
            Ticket ticket = ticketSeller.getTicketOffice().getTicket(); // 문제점: 티켓판매자가 속한 티켓오피스에서 직접 티켓을 가져온다고...!?
            audience.getBag().setTicket(ticket); // 문제점: 손님 가방에 직접 티켓을 챙겨주네...
        } else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket(); // 문제점: 위와 동일
            audience.getBag().minusAmount(ticket.getFee()); // 문제점: 위와 동일
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee()); // 문제점: 위와 동일
            audience.getBag().setTicket(ticket); // 문제점: 위와 동일
        }
    }

    //2 변경이 용이하지 않을 것이다.
    // 관람객과 티켓판매원(Audience, TicketSeller) 클래스를 변경할 경우 Theater도 변경해야 된다.
    // 예를들어, 고객이 가방을 들고 있지 않다면 어떻게 해야 할까?
    // 또 현금이 아니라 신용카드를 이용해서 결제한다면?
    // Audience의 내부에 대해 더 많이 알면 알수록 Audience를 변경하기 어려워진다. (의존성 문제)

    //3 코드를 읽는 사람과 의사소통되어야 한다.
    // 이해하기 어려운 이유는,
    // Theater의 enter 메서드를 이해하기 위해서는 Audience가 Bag을 가지고 있고,
    // Bag 안에는 현금과 티켓이 들어 있으며 Ticketseller가 Ticketoffice에서 티켓을 판매하고,
    // Ticketoffice 안에 돈과 티켓이 보관돼 있다는 모든 사실을 기억하고 있어야 한다.

    // 로버트 마틴 3가지 목적에 불만족...
}
