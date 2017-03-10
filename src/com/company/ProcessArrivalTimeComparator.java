package com.company;

import java.util.Comparator;

/**
 * Created by Igor on 07.03.2017.
 */
public class ProcessArrivalTimeComparator implements Comparator<Process> {
    public int compare(Process p1, Process p2){
        int temp;
        if(p1.getArrivalTime() < p2.getArrivalTime()) temp = -1;
        else if(p1.getArrivalTime() > p2.getArrivalTime()) temp = 1;
        else temp =0;
        return temp;
    }
}
