package com.example.niloychowdhury.groceryshopmanagement.Model;

import java.io.Serializable;

/**
 * Created by Niloy Chowdhury on 2017-09-07.
 */

public class SubCategary implements Serializable {
    public int subCategoryID;
    public String subCategoryName;
    public double sale;
    public double stock;
    public double price;
    public String status;
    public int categoryID;
    public String dateTime;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(int subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public SubCategary(int subCategoryID, String subCategoryName, double sale, double stock, double price, String status, int categoryID,String dateTime) {
        this.subCategoryID = subCategoryID;
        this.subCategoryName = subCategoryName;
        this.sale = sale;
        this.stock = stock;
        this.price = price;
        this.status = status;
        this.dateTime=dateTime;
        this.categoryID = categoryID;
    }

    public SubCategary(String subCategoryName, double sale, double stock, double price, String status, int categoryID) {
        this.subCategoryName = subCategoryName;
        this.sale = sale;
        this.stock = stock;
        this.price = price;
        this.status = status;
        this.categoryID = categoryID;
    }

}
