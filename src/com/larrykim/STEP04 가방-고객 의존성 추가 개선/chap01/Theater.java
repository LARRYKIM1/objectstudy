package com.larrykim.chap01;

import com.larrykim.chap01.Audience;

public class Theater {
    public TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller){
        this.ticketSeller=ticketSeller;
    }

    public void enter(Audience audience) {
        //무전기로 손님 갑니다. 메시지 전달.
        ticketSeller.sellTo(audience);
    }


//     해결사항 정리
//     Audience와 Ticketseller에 관해 세세한 부분까지 알지 못하도록 정보를 차단
//     관람객이 스스로 가방 안의 현금과 초대장을 처리하고
//     판매원이 스스로 매표소의 티켓과 판매 요금을 다루게 되었다. (자율gu적 존재로 개선)
//     세부적인 사항을 감추는 것을 캡슐화라 한다. (캡슐화 목적: 변경하기 쉬운 객체를 만드는 것)
//
//     알아둘것
//     Theater는 오직 TicketSeller의 인터페이스(interface)에만 의존한다. (sellTo)
//     객체를 인터페이스와 구현으로 나누고 인터페이스만을 공개 (TicketOffice는 구현의 영역)
//     객체 사이의 결합도를 낮추고 변경하기 쉬운 코드를 작성하기 위해 따라야 하는 가장 기본적인 설계 원칙
}
