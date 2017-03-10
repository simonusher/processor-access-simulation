package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Created by Igor on 07.03.2017.
 */
public class Queue {
    List<Process> processList;
    int acc = 0;
    ProcessArrivalTimeComparator patc;
    public Queue(){
        processList = new ArrayList<>();
        Random generator = new Random();
        int size = generator.nextInt(21) + 30;
        int arrivedAtStart = generator.nextInt(size-1) + 2;
        int arrivedLater = size - arrivedAtStart;

        for (int i = 0; i < arrivedAtStart; i++) {
            processList.add(Process.generateRandomProcess(0));
            acc += processList.get(i).getBurstTime();
        }

        for (int i = size - arrivedLater; i < size; i++) {
            processList.add(Process.generateRandomProcess(generator.nextInt(acc)+1));
            acc += processList.get(i).getBurstTime();
        }

        patc = new ProcessArrivalTimeComparator();
        processList.sort(patc);
//        System.out.println(size + " " + arrivedAtStart + " " + processList.size());
    }

    public List<Process> getProcessList() {
        return processList;
    }

    public void setProcessList(List<Process> processList) {
        this.processList = processList;
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }

    public String toString(){
        String temp = "";
        for (int i = 0; i < processList.size(); i++) {
            temp += processList.get(i);
            temp += System.lineSeparator();
        }
        return temp;
    }

    public double countAverageWaitTime(){
        double sum = 0;
        for (Process p: processList) {
            sum += p.getWaitTime();
        }
        return sum/processList.size();
    }

    public void reset(){
        this.processList.sort(patc);
        for (Process p: processList) {
            p.reset();
        }
    }

    public boolean isDone(){
        for (Process p: processList) {
            if(!p.isDone()) return false;
        }
        return true;
    }


}
