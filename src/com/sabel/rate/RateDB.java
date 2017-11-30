package com.sabel.rate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RateDB {

    private List<Rate> list;

    public RateDB() {
        this.list = new ArrayList<>();
    }

    public int size() {
        return this.list.size();
    }

    public boolean add(Rate rate) {
        this.list.add(rate);
        return true;
    }

    public boolean add(long timestamp, double rateEUR, double rateUSD) {
        Rate rate = new Rate(timestamp, rateEUR, rateUSD);
        this.list.add(rate);
        return true;
    }

    public Rate getLastRate() {
        return this.list.get(this.list.lastIndexOf(list));
    }

    public Rate get(int index) {
        Rate rate = null;
        if (index < this.list.size() && index >= 0) {
            rate = this.list.get(index);
        }
        return rate;
    }

    public List<Rate> get(long beginTimestamp, long endTimestamp) {
        List<Rate> listDuration = null;
        Rate rate = null;
        for (int i = 0; i < this.list.size(); i++) {
            rate = list.get(i);
            if (rate.getTimestamp() >= beginTimestamp && rate.getTimestamp() <= endTimestamp) {
                listDuration.add(rate);
            }
        }
        return listDuration;
    }

    public Rate remove(long timestamp) {
        Iterator<Rate> iterator = list.iterator();
        while (iterator.hasNext()){
            Rate nextRate = iterator.next();
            if(nextRate.getTimestamp() == timestamp){
                iterator.remove();
                return nextRate;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String writeDown = "";
        Rate rate = null;
        for (int i = 0; i < this.list.size(); i++) {
            rate = this.list.get(i);
            writeDown += "Zeitstempel: " + rate.getTimestamp() + " Kurs in Euro: " + rate.getRateEUR() + " Kurs in USD: " + rate.getRateUSD() + "\n";
        }
        return writeDown;
    }
}
