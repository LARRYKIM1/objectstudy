package com.larrykim;

import com.larrykim.chap01.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        // 영화관 + 티켓오피스 + 티켓판매자 생성
        Theater theater = generateTheater();

        // 관람객 생성
        List<Audience> audienceList = generateAudience();

        System.out.println("============================");
        System.out.println("고객 두분이 오셨습니다.");
        for(Audience audience : audienceList)
            theater.enter(audience);
        System.out.println("============================");
        System.out.println("고객이 상영관에 들어갑니다.");
    }

    public static Theater generateTheater(){

        //티켓오피스 100만원 + 10개 티켓 넣어준다.
        //티켓판매자를 티켓오피스에 배정
        List<Ticket> ticketList = generateTicket();
        TicketOffice ticketOffice = new TicketOffice(1000000l, ticketList);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        System.out.println("영화관 + 티켓오피스 + 티켓판매자 생성 완료...");
        return new Theater(ticketSeller);
    }

    public static List<Ticket> generateTicket(){
        List<Ticket> ticketList = new ArrayList<>();
        for(int i=1;i<10;i++){
            Ticket ticket = new Ticket();
            ticket.setTitle("왕의남자");
            ticket.setFee(10000l);
            ticketList.add(ticket);
        }
        System.out.println("티켓 생성 완료...");
        return ticketList;
    }

    public static List<Audience> generateAudience(){

        //초대장은 어느영화인지 상관없고 날짜만 해당하면 입장가능
        LocalDateTime localDateTime = LocalDateTime.of(20,12,25,20,00);
        Invitation invitation = new Invitation(localDateTime);

        List<Audience> audienceList = new ArrayList<>();

        //초대장 있는 회원
        Bag bag1 = new Bag(invitation,50000l);
        Audience audience1 = new Audience();
        audience1.setBag(bag1);
        audienceList.add(audience1);

        //초대장 없는 회원
        Bag bag2 = new Bag(50000l);
        Audience audience2 = new Audience();
        audience2.setBag(bag2);
        audienceList.add(audience2);

        System.out.println("관람객 2명 생성 완료...");
        return audienceList;
    }
}
