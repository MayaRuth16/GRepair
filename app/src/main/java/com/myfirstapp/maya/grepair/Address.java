package com.myfirstapp.maya.grepair;

public class Address {
    public int Id;
    public String District;
    public int Id_User;

    public Address() {
    }

    public Address(int id, String district, int id_User) {
        Id = id;
        District = district;
        Id_User = id_User;
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

    public int getIdUser() {
        return Id_User;
    }

    public void setIdUser(int id_User) {
        Id_User = id_User;
    }
}
