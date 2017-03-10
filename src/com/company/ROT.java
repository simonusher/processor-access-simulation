package com.company;

/**
 * Created by Igor on 09.03.2017.
 */
public class ROT extends Strategy {
    private int quantum;

    public ROT(Queue queue, int quantum) {
        super(queue);
        this.quantum = quantum;
    }

    public void run(){
        while(!queue.isDone()){
            for (int i = startIndex; i <= endIndex; i++) {
                if (rangeCheck()) break;
                activeProcess = processQueue.get(i);
                if (!activeProcess.isDone()) {
                    if (quantum >= activeProcess.getRemainingTime()) {
                        int difference = activeProcess.getRemainingTime();
                        for (int k = 0; k < difference; k++) {
                            passTime();
                            rangeCheck();
                        }
                    } else {
                        for (int k = 0; k < quantum; k++) {
                            passTime();
                            rangeCheck();
                        }
                    }
                }
            }
        }
    }
}
