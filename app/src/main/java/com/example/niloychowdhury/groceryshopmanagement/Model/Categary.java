package com.example.niloychowdhury.groceryshopmanagement.Model;

/**
 * Created by Niloy Chowdhury on 2017-08-31.
 */

public class Categary {
    public int id;
    public String categaryName;
    public String dateTime;
    public String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategryName() {
        return categaryName;
    }

    public void setCategryName(String categryName) {
        this.categaryName = categryName;
    }

    public String getCategaryName() {
        return categaryName;
    }

    public void setCategaryName(String categaryName) {
        this.categaryName = categaryName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
public Categary(){}
    public Categary(String categaryName, String status) {

        this.categaryName = categaryName;
        this.status=status;
    }

    public Categary(int id, String categaryName, String dateTime, String status) {
        this.id = id;
        this.categaryName = categaryName;
        this.dateTime = dateTime;
        this.status = status;
    }
}

