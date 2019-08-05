package com.myfirstapp.maya.grepair;

public class User {

    public int Id;
    public int Image;
    public String Name;
    public int Number;
    public String Email;
    public String Pasword;

    public User() {
    }

    public User(int id, int image, String name, int number, String email, String pasword) {
        Id = id;
        Image = image;
        Name = name;
        Number = number;
        Email = email;
        Pasword = pasword;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPasword() {
        return Pasword;
    }

    public void setPasword(String pasword) {
        Pasword = pasword;
    }
}

