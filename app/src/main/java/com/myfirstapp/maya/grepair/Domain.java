package com.myfirstapp.maya.grepair;

public class Domain {
    public int Id;
    public String Name;
    public int Image;
    public String Description;

    public Domain() {
    }

    public Domain(int id, String name, int image, String description) {
        Id = id;
        Name = name;
        Image = image;
        Description = description;
    }

    public Domain( String name, int image, String description) {
        Name = name;
        Image = image;
        Description = description;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
