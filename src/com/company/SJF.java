package com.company;

import java.util.Collections;
import java.util.List;

/**
 * Created by Igor on 09.03.2017.
 */
public class SJF implements Strategy {
    private Queue queue;
    private List<Process> listaProcesow;
    private int timePassed = 0;
    private int startIndex = 0;
    private int endIndex = 0;
    private ProcessBurstTimeComparator pbtc;
    private ProcessRemainingTimeComparator prtc;

    public SJF(Queue queue){
        this.queue = queue;
        listaProcesow = queue.getProcessList();
        this.pbtc = new ProcessBurstTimeComparator();
    }

    public void run() {
        Process p;
        while (!queue.isDone()) {
            for (int i = startIndex; i <= endIndex; i++) {
                if (rangeCheck()) break;
                Collections.sort(queue.getProcessList().subList(startIndex, endIndex+1), pbtc);
                p = listaProcesow.get(i);
                while (!p.isDone()) {
                    timePassed++;
                    for (Process q : listaProcesow.subList(startIndex, endIndex+1)) {
                        if (!p.equals(q) && !q.isDone()) q.addWaitTime(1);
                    }
                    p.addDoneTime(1);
                    rangeCheck();
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
