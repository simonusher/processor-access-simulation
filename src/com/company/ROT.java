package com.company;

import java.util.List;

/**
 * Created by Igor on 09.03.2017.
 */
public class ROT implements Strategy {
    private Queue queue;
    private List<Process> listaProcesow;
    private int quantum;
    private int timePassed;
    private int startIndex = 0;
    private int endIndex = 0;

    public ROT(Queue queue, int quantum) {
        this.queue = queue;
        this.timePassed = 0;
        this.listaProcesow = queue.getProcessList();
        this.quantum = quantum;
        rangeCheck();
    }

    public void run(){
        Process p;
        while(!queue.isDone()){
            for (int i = startIndex; i <= endIndex; i++) {
                if (rangeCheck()) break;
                p = listaProcesow.get(i);
                if (!p.isDone()) {
                    if (quantum >= p.getRemainingTime()) {
                        int difference = p.getRemainingTime();
                        for (int k = 0; k < difference; k++) {
                            timePassed++;
                            p.addDoneTime(1);
                            p.updateRemainingTime();
                            for (Process q: listaProcesow.subList(startIndex, endIndex+1)) {
                                if(!p.equals(q) && !q.isDone()) q.addWaitTime(1);
                            }
                            rangeCheck();
                        }
                    } else {
                        for (int k = 0; k < quantum; k++) {
                            timePassed++;
                            p.addDoneTime(1);
                            p.updateRemainingTime();
                            for (Process q: listaProcesow.subList(startIndex, endIndex+1)) {
                                if(!p.equals(q) && !q.isDone()) q.addWaitTime(1);
                            }
                            rangeCheck();
                        }
                    }
                }
            }
        }
    }


    public boolean rangeCheck(){
        boolean wasChanged = false;
        while(startIndex < listaProcesow.size()){
            if(!listaProcesow.get(startIndex).isDone()) break;
            else {
                startIndex++;
                wasChanged = true;
            }
        }

        while (endIndex < listaProcesow.size()){
            if(endIndex + 1 == listaProcesow.size()) break;
            else if(listaProcesow.get(endIndex + 1).getArrivalTime() > timePassed) break;
            else{
                endIndex++;
                wasChanged = true;
            }
        }
        return wasChanged;
    }
}
