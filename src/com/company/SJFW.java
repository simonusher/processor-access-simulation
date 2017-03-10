package com.company;

import java.util.Collections;

/**
 * Created by Igor on 09.03.2017.
 */
public class SJFW extends Strategy {
    private ProcessRemainingTimeComparator prtc;

    public SJFW(Queue queue){
        super(queue);
        this.prtc = new ProcessRemainingTimeComparator();
    }

    public void run() {
        while (!queue.isDone()) {
            for (int i = startIndex; i <= endIndex; i++) {
                if (rangeCheck()) break;
                Collections.sort(activeQueue, prtc);
                activeProcess = processQueue.get(i);
                while (!activeProcess.isDone()) {
                    super.passTime();
                    super.rangeCheck();
                    Collections.sort(activeQueue, prtc);
                    activeProcess = processQueue.get(i);
                }
            }
        }
    }
}