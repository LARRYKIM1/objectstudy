package com.larrykim.chap01;

public class Audience {
    private Bag bag;

    public Bag getBag(){
        return bag;
    }

    public void setBag(Bag bag){
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        if (bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;
        } else {
            bag.setTicket(ticket);
            bag.minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
}
