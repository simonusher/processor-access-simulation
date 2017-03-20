package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Queue> qal = new ArrayList<>();

        /**
         * Zmienna przechowująca ilość ciągów testowych.
         */
        int numberOfQueues = 30;
        /**
         * Zmienne pomocnicze do sumowania średnich dla pojedynczych wyników
         * i wyświetlania średnich ze wszystkich kolejek.
         */
        int _FCFSSum = 0, _ROTSum = 0, _SJFSum = 0, _SJFWSum = 0;
        double r1 = 0, r2 = 0, r3 = 0, r4 = 0;


        for (int i = 0; i < numberOfQueues; i++) {
            qal.add(new Queue());
        }


        /**
         * Kolejka testowa z czterema procesami.
         * Wyniki: FCFS - 21.25, ROT - 13.25, SJF - 11.75, SJFW - 6.0
         */

//        Process p1 = new Process(0, 15, 0);
//        Process p2 = new Process(0, 20, 0);
//        Process p3 = new Process(1, 3, 0);
//        Process p4 = new Process(2, 1, 0);
//
//        ArrayList<Process> processArrayList = new ArrayList<>();
//        processArrayList.add(p1);
//        processArrayList.add(p2);
//        processArrayList.add(p3);
//        processArrayList.add(p4);
//
//        Queue q = new Queue();
//        q.setProcessList(processArrayList);
//
//        FCFS f = new FCFS(q);
//        f.run();
//        System.out.println(q.countAverageWaitTime());
//        q.reset();
//        ROT r = new ROT(q, 5);
//        r.run();
//        System.out.println(q.countAverageWaitTime());
//        q.reset();
//        SJF s = new SJF(q);
//        s.run();
//        System.out.println(q.countAverageWaitTime());
//        q.reset();
//        SJFW sw = new SJFW(q);
//        sw.run();
//        System.out.println(q.countAverageWaitTime());
//        q.reset();




        for (Queue q : qal) {

            FCFS f = new FCFS(q);
            f.run();
//            System.out.println(q);
            r1 = q.countAverageWaitTime();
            _FCFSSum += r1;
//            System.out.print(String.format("%.2f", r1) + " ");
            q.reset();

            ROT r = new ROT(q, 20);
            r.run();
            r2 = q.countAverageWaitTime();
            _ROTSum += r2;
//            System.out.print(String.format("%.2f", r2) + " ");
            q.reset();

            SJF s = new SJF(q);
            s.run();
            r3 = q.countAverageWaitTime();
            _SJFSum += r3;
//            System.out.print(String.format("%.2f", r3) + " ");
//            System.out.println(q);
            q.reset();
//
            SJFW sjfw = new SJFW(q);
            sjfw.run();
//            System.out.println(q);
            r4 = q.countAverageWaitTime();
            _SJFWSum += r4;
//            System.out.println(String.format("%.2f", r4));
            q.reset();
        }
        System.out.println("Średnie czasy oczekiwania dla wszystkich kolejek:");
        System.out.println("FCFS: " + r1/numberOfQueues);
        System.out.println("ROT: " + r2/numberOfQueues);
        System.out.println("SJF: " + r3/numberOfQueues);
        System.out.println("SJFW: " + r4/numberOfQueues);
    }
}
