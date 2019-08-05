package com.myfirstapp.maya.grepair;

public class Order {
    public int Id;
    public String District;
    public int Number;
    public int Hour;
    public String Date;
    public String Description;
    public int User_id;
    public int Subdomain_id;

    public Order() {
    }

    public Order(int id, String district, int number, int hour, String date, String description, int user_id, int subdomain_id) {
        Id = id;
        District = district;
        Number = number;
        Hour = hour;
        Date = date;
        Description = description;
        User_id = user_id;
        Subdomain_id = subdomain_id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public Integer getHour() {
        return Hour;
    }

    public int setHour(int hour) {
        return hour;
    }

    public String getDate() {
        return Date;
    }

    public String setDate(String date) {
        return date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getIdUser() {
        return User_id;
    }

    public void setIdUser(int user_id) {
        User_id = user_id;
    }

    public int getIdSubDomain() {
        return Subdomain_id;
    }

    public void setIdSubDomain(int subdomain_id) {
        Subdomain_id = subdomain_id;
    }
}
