package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Queue> qal = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            qal.add(new Queue());
        }

        System.out.println("FCFS ROT SJF SJFW");
        for (Queue q : qal) {

            FCFS f = new FCFS(q);
            f.run();
//            System.out.println(q);
            System.out.print(String.format("%.2f", q.countAverageWaitTime()) + " ");
            q.reset();

            ROT r = new ROT(q, 20);
            r.run();
            System.out.print(String.format("%.2f", q.countAverageWaitTime()) + " ");
            q.reset();

            SJF s = new SJF(q);
            s.run();
            System.out.print(String.format("%.2f", q.countAverageWaitTime()) + " ");
//            System.out.println(q);
            q.reset();
//
            SJFW sjfw = new SJFW(q);
            sjfw.run();
//            System.out.println(q);
            System.out.println(String.format("%.2f", q.countAverageWaitTime()));
            q.reset();
        }
    }
}
