package com.sabel.threads;

public class Thread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i<100;i++){
            System.out.println("Threat 1 " + i);
        }
    }
}
