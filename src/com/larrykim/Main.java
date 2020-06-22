package com.larrykim;

import com.larrykim.chap01.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        // 영화관 생성
        Theater theater = generateTheater();

        // 관람객 생성
        Audience audience = generateAudience();

        System.out.println("enter 메서드 실행...");
        theater.enter(audience);

    }

    public static Theater generateTheater(){

        //티켓오피스 100만원 + 10개 티켓 넣어준다.
        //티켓판매자를 티켓오피스에 배정
        List<Ticket> ticketList = generateTicket();
        TicketOffice ticketOffice = new TicketOffice(1000000l, ticketList);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        
        return new Theater(ticketSeller);
    }

    public static List<Ticket> generateTicket(){
        List<Ticket> ticketList = new ArrayList<>();
        for(int i=1;i<10;i++){
            Ticket ticket = new Ticket();
            ticket.setFee(1000l);
            ticketList.add(ticket);
        }
        System.out.println("티켓 생성 완료...");
        return ticketList;
    }

    public static Audience generateAudience(){
        LocalDateTime localDateTime = LocalDateTime.now();
        Invitation invitation = new Invitation(localDateTime);

        //초대장과 5만원 가방에 넣어준다.
        Bag bag = new Bag(invitation,50000l);

        Audience audience = new Audience();

        audience.setBag(bag);

        System.out.println("관람객 생성 완료...");
        return audience;
    }
}
