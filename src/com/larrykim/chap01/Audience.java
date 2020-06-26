package com.larrykim.chap01;

public class Audience {
    private Bag bag;

    public Bag getBag(){
        return bag;
    }

    public void setBag(Bag bag){
        this.bag = bag;
    }

    //고객 가방에

    public Long buy(Ticket ticket) {
        return bag.hold(ticket);

       /* if (bag.hasInvitation()) { //본인이 직접 가방 확인.
            System.out.println("1 손님: 초대장이 있어요^^!");
            bag.setTicket(ticket);
            return 0L; //초대장이 있으니 돈줄 필요 x
        } else {
            System.out.println("2 손님: 초대장이 없어요ㅜㅜ");
            System.out.printf("2 손님: 제가방에서 %d원을 감소시키고 돈을 전달할게요.\n",ticket.getFee());
            bag.setTicket(ticket);
            bag.minusAmount(ticket.getFee());
            return ticket.getFee();
        }*/
    }
}
