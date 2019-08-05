package com.myfirstapp.maya.grepair;

public class Subdomain {
    public int Id;
    public String Libelle;
    public int Id_Domain;

    public Subdomain() {
    }

    public Subdomain(int id, String libelle, int id_Domain) {
        Id = id;
        Libelle = libelle;
        Id_Domain = id_Domain;
    }

    public Subdomain( String libelle) {
        Libelle = libelle;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public int getIdDomain() {
        return Id_Domain;
    }

    public void setIdDomain(int id_Domain) {
        Id_Domain = id_Domain;
    }
}
