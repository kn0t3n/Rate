package com.sabel.threads;

public class Thread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i<100;i++){
            System.out.println("Threat 2 " + i);
        }
    }
}