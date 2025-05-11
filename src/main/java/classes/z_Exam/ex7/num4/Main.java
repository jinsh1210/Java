package classes.z_Exam.ex7.num4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Ticket> v = new ArrayList<Ticket>();

        v.add(new Ticket("뮤지컬",50000));
        v.add(new VipTicket("콘서트",80000));
        v.add(new StudentTicket("영화",15000,"홍길동"));

        for(Ticket ticket : v) {
            System.out.println(ticket.getInfo());
            System.out.println(ticket.getPrice());
            System.out.println();
        }
    }
}
