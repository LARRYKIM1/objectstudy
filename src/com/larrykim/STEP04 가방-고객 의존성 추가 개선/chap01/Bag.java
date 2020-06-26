package com.larrykim.chap01;

public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Bag(Long amount){
        this(null, amount);
    }

    public Bag(Invitation invitation, Long amount){
        this.invitation=invitation;
        this.amount=amount;
    }

    private boolean hasInvitation(){
        return invitation != null;
    }

    public Long hold(Ticket ticket){
        if(hasInvitation()){
            System.out.println("가방: 초대장 있어요.");
            setTicket(ticket);
            return 0l;
        }else{
            System.out.println("가방: 초대장 없어요.");
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

   /* public boolean hasTicket(){
        return ticket != null;
    }*/
    private void setTicket(Ticket ticket){
        this.ticket = ticket;
    }
    private void minusAmount(Long amount){
        this.amount-=amount;
    }
    /*public void plusAmount(Long amount){
        this.amount+=amount;
    }*/

}
