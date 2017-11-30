package com.sabel.rate;

import java.sql.SQLException;
import java.util.Date;

public class Testklasse {

    public static void main(String[] args) {


        Rate rate = new Rate(new Date().getTime()/1000, 1,1);
        Rate rate2 = new Rate(2, 2,2);
        Rate rate3 = new Rate(3, 3,3);
        Rate rate4 = new Rate(4, 4,4);

        RateDB rateDB = new RateDB();
        rateDB.add(rate);
        rateDB.add(rate2);
        rateDB.add(rate3);
        rateDB.add(rate4);

        System.out.println(rateDB.size());

        System.out.println(rateDB.get(2));

        //System.out.println(rateDB.get(1,2));

        RateService rateService = null;
        try {
            rateService = new RateService();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rateService.save(rate);
            rateService.save(rate2);
            rateService.save(rate3);
            rateService.save(rate4);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        RateDB rateDB1 = null;
        try {
            rateDB1 =  rateService.readAllRates();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(rateDB1.size());
        System.out.println(rateDB1.toString());
        System.out.println(rateDB1.getLastRate());

        try {
            rateService.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}