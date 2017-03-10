package com.company;
import java.util.Random;
/**
 * Created by Igor on 07.03.2017.
 */
public class Process {
    private int arrivalTime;
    private int burstTime;
    private int waitTime;
    private int doneTime;
    private int remainingTime;


    public Process(){

    }

    public Process(int arrivalTime, int burstTime, int waitTime){
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.waitTime = waitTime;
        this.doneTime = 0;
        remainingTime = this.burstTime - doneTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public void addWaitTime(int waitTime){
        this.waitTime+=waitTime;
    }

    public int getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(int doneTime) {
        this.doneTime = doneTime;
    }

    public void addDoneTime(int doneTime){
        this.doneTime += doneTime;
    }

    public void updateRemainingTime(){
        this.remainingTime = this.burstTime - this.doneTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public static Process generateRandomProcess(int arrivalTime){
        Random generator = new Random();
        int burstTime;
        int waitTime = 0;
        int temp;

        temp = generator.nextInt(100)+1;
        if(temp>90){
            burstTime = generator.nextInt(30)+21;
        }
        else if(temp>60){
            burstTime = generator.nextInt(15)+6;
        }
        else {
            burstTime = generator.nextInt(5)+1;
        }
        return new Process(arrivalTime, burstTime, waitTime);
    }

    public void reset(){
        waitTime = 0;
        doneTime = 0;
        remainingTime = burstTime - doneTime;
    }

    public String toString(){
        return String.format("%-3d %-3d %-3d %-3d %-3d", arrivalTime, burstTime, waitTime, doneTime, remainingTime );
    }

    public boolean isDone(){
        return doneTime >= burstTime;
    }
}
