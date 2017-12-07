package com.sabel.rate;

import java.sql.*;

public class RateService {

    private Connection connection;
    private PreparedStatement pStatInsert, pStatSelect;
    private static int letzteID = 0;
    private int id;


    public RateService() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlite:d:\\rates.sqlite");
        this.pStatInsert = null;
        this.pStatSelect = null;
    }

    public void save(Rate rate) throws SQLException {
        id++;
        String sql = "INSERT INTO rates VALUES(" + id + "," +rate.getTimestamp() + ", '" + rate.getRateEUR() + "', " + rate.getRateUSD() + ")";
        pStatInsert = connection.prepareStatement(sql);
        this.pStatInsert.executeUpdate();
    }

    public void close() throws SQLException {
        if (this.connection != null) {
            connection.close();
        }
    }

    public RateDB readAllRates() throws SQLException {
        RateDB rateDB = new RateDB();
        ResultSet resultSet = null;
        String sql = "SELECT id, timestamp, rateEUR, rateUSD FROM rates";
        pStatSelect = connection.prepareStatement(sql);
        resultSet = this.pStatSelect.executeQuery();
        while (resultSet.next()){
            rateDB.add(new Rate(resultSet.getLong(2),resultSet.getDouble(3), resultSet.getDouble(4)));
        }
        return rateDB;
    }

    public Rate readLastRate() throws SQLException {
        ResultSet resultSet = null;
        Rate rate = null;
        String sql = "SELECT index, timestamp, rateEUR, rateUSD FROM rates";
        pStatSelect = connection.prepareStatement(sql);
        resultSet = this.pStatSelect.executeQuery();
        if(resultSet.isLast()){
            rate.setTimestamp(resultSet.getLong(2));
            rate.setRateEUR(resultSet.getDouble(3));
            rate.setRateUSD(resultSet.getDouble(4));
        }
        return rate;
    }
}