package com.sabel.threads;

public class ThreadTest {
    public static void main(String[] args) {

    MeinThread meinThread1 = new MeinThread();
    MeinThread meinThread2 = new MeinThread();
    meinThread1.start();
    meinThread2.start();
        System.out.println("Ich habe in main 2 Threads gestartet");
        System.out.println("Main ist fertig");
    }

}
