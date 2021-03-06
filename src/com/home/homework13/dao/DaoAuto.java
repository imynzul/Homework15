package com.home.homework13.dao;

import com.home.homework13.database.DB;
import com.home.homework13.entity.Auto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAuto implements CarRentInterface<Auto> {

    private DB db;

    public DaoAuto(DB db) {
        this.db = db;
    }

    @Override
    public void insert(Auto ob) {
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement("INSERT INTO auto VALUES(?,?)");
            preparedStatement.setInt(1, ob.getId());
            preparedStatement.setString(2, ob.getCarModel());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Auto ob) {
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement("UPDATE auto SET car_model=? WHERE id=?");
            preparedStatement.setString(1, ob.getCarModel());
            preparedStatement.setInt(2, ob.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement("DELETE FROM auto WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Auto get(int id) {
        Auto auto = null;
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement("SELECT * FROM auto WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                auto = new Auto(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return auto;
    }

    public ResultSet getAll(){
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement("SELECT * FROM auto");
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultSet;
    }
}
