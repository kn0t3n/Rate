package com.sabel.threads;

public class MeinThread extends Thread {

    private int counter = 0;

    @Override
    public void run() {
        // Nie selber aufrufen!
        // Coder der ausgeführt werden soll
        String name = getName();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println(name + " : " + ++counter);
        }
        System.out.println(name + " : Ich bin fertig");
    }


}
