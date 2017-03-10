package com.company;

import java.util.Comparator;

/**
 * Created by Igor on 09.03.2017.
 */
public class ProcessRemainingTimeComparator implements Comparator<Process> {
    public int compare(Process p1, Process p2){
        int temp;
        if(p1.getRemainingTime() < p2.getRemainingTime()) temp = -1;
        else if(p1.getRemainingTime() > p2.getRemainingTime()) temp = 1;
        else temp =0;
        return temp;
    }
}