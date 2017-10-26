package com.example.niloychowdhury.groceryshopmanagement.Model;

/**
 * Created by Niloy Chowdhury on 2017-09-13.
 */

public class POS
{
 public int categoryID;
 public int subCategoryID;
 public int posID;
    public double quantity;
    public double price;
    public String datetime;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public POS(int categoryID, int subCategoryID, int posID, double quantity, double price,String datetime) {
        this.categoryID = categoryID;
        this.subCategoryID = subCategoryID;
        this.posID = posID;
        this.quantity = quantity;
        this.price = price;
        this.datetime=datetime;
    }

    public POS(int categoryID, int subCategoryID, double quantity, double price) {
        this.categoryID = categoryID;
        this.subCategoryID = subCategoryID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getSubCategoryID() {
        return subCategoryID;
    }

    public void setSubCategoryID(int subCategoryID) {
        this.subCategoryID = subCategoryID;
    }

    public int getPosID() {
        return posID;
    }

    public void setPosID(int posID) {
        this.posID = posID;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
