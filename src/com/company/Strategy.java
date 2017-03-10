package com.company;

import java.util.List;

/**
 * Created by Igor on 07.03.2017.
 */
public abstract class Strategy {
    protected Queue queue;
    protected List<Process> processQueue;
    protected List<Process> activeQueue;
    protected Process activeProcess;
    protected int timePassed;
    protected int startIndex;
    protected int endIndex;

    public Strategy(Queue queue) {
        this.queue = queue;
        this.startIndex = 0;
        this.endIndex = 0;
        this.timePassed = 0;
        this.processQueue = queue.getProcessList();
        rangeCheck();
        this.activeQueue = processQueue.subList(startIndex, endIndex+1);
    }

    public abstract void run();

    public boolean rangeCheck(){
        boolean wasChanged = false;
        while(startIndex < processQueue.size()){
            if(!processQueue.get(startIndex).isDone()) break;
            else {
                startIndex++;
                wasChanged = true;
            }
        }

        while (endIndex < processQueue.size()){
            if(endIndex + 1 == processQueue.size()) break;
            else if(processQueue.get(endIndex + 1).getArrivalTime() > timePassed) break;
            else{
                endIndex++;
                wasChanged = true;
            }
        }
        if(wasChanged) updateActiveQueue();
        return wasChanged;
    }

    public void updateActiveQueue(){
        activeQueue = processQueue.subList(startIndex, endIndex+1);
    }

    public void passTime(){
        timePassed++;
        for (Process p: activeQueue) {
            if(!p.isDone() && !p.equals(activeProcess)){
                p.addWaitTime(1);
            }
        }
        activeProcess.addDoneTime(1);
        activeProcess.updateRemainingTime();
    }
}
