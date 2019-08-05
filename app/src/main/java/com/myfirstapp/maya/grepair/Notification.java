package com.myfirstapp.maya.grepair;

import java.util.Date;

public class Notification {
    public int Id;
    public String Title;
    public String Message;
    public String Link;
    public Date Date;

    public Notification() {
    }

    public Notification(int id, String title, String message, String link, java.util.Date date) {
        Id = id;
        Title = title;
        Message = message;
        Link = link;
        Date = date;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }
}
