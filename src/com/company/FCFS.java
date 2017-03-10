package com.company;

import java.util.List;

/**
 * Created by Igor on 09.03.2017.
 */
public class FCFS extends Strategy {

    public FCFS(Queue queue){
        super(queue);
    }

    public void run(){
        while(!queue.isDone()){
            for (int i = startIndex; i <= endIndex; i++) {
                if(rangeCheck()) break;
                activeProcess = processQueue.get(i);

                while(!activeProcess.isDone()){
                    super.passTime();
                    super.rangeCheck();
                }
            }
        }
    }
}
