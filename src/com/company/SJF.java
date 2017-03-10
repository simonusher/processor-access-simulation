package com.company;

import java.util.Collections;

/**
 * Created by Igor on 09.03.2017.
 */
public class SJF extends Strategy {
    private ProcessBurstTimeComparator pbtc;

    public SJF(Queue queue){
        super(queue);
        this.pbtc = new ProcessBurstTimeComparator();
    }

    public void run() {
        while (!queue.isDone()) {
            for (int i = startIndex; i <= endIndex; i++) {
                if (rangeCheck()) break;
                Collections.sort(activeQueue, pbtc);
                activeProcess = processQueue.get(i);
                while (!activeProcess.isDone()) {
                    super.passTime();
                    super.rangeCheck();
                }
            }
        }
    }
}
