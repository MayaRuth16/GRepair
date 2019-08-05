package com.myfirstapp.maya.grepair;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Globalrepair.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase dbWrite = this.getWritableDatabase();
    private SQLiteDatabase dbRead = this.getReadableDatabase();



    // Table names
    public static final String TABLE_USER="user_table";
    public static final String TABLE_ADDRESS="address_table";
    public static final String TABLE_ORDER="order_table";
    public static final String TABLE_DOMAIN="domain_table";
    public static final String TABLE_SUBDOMAIN="subdomain_table";
    //public static final String TABLE_NOTIFICATION="notification_table";



    // USER Table = colums names
    public static final String USER_Id="Id";
    public static final String USER_Image="Image";
    public static final String USER_Name="Name";
    public static final String USER_Number="Number";
    public static final String USER_Email="Email";
    public static final String USER_Password="Password";

    // ADDRESS Table = colums names
    public static final String ADDRESS_Id="Id";
    public static final String ADDRESS_District="District";
    public static final String ADDRESS_USER_ID = "User_id";

    // ORDER Table = colums names
    public static final String ORDER_Id="Id";
    public static final String ORDER_District="District";
    public static final String ORDER_Number="Number";
    public static final String ORDER_Hour="Hour";
    public static final String ORDER_Date="Date";
    public static final String ORDER_Description="Description";
    public static final String ORDER_SUBDOMAIN_ID = "Subdomain_id";
    public static final String ORDER_USER_ID = "user_id";

    // DOMAIN Table = colums names
    public static final String DOMAIN_Id="Id";
    public static final String DOMAIN_Name="Name";
    public static final String DOMAIN_Image="Image";
    public static final String DOMAIN_Description="Description";

    // SUBDOMAIN Table = colums names
    public static final String SUBDOMAIN_Id="Id";
    public static final String SUBDOMAIN_Libelle="Libelle";
    public static final String SUBDOMAIN_DOMAIN_ID = "Domain_id";

    /* NOTIFICATION Table = colums names
    public static final String NOTIFICATION_Id="Id";
    public static final String NOTIFICATION_Title="Title";
    public static final String NOTIFICATION_Message="Message";
    public static final String NOTIFICATION_Link="Link";
    public static final String NOTIFICATION_Date="Date"; */

    //CREATE STATEMENTS

    //USER TABLE CREATE STATEMENTS
    private static final String CREATE_TABLE_USER = "CREATE TABLE " +
            TABLE_USER + "(" +
            USER_Id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            USER_Image + " INTEGER, " +
            USER_Name + " TEXT, "+
            USER_Number + " INTEGER, " +
            USER_Email + " TEXT, " +
            USER_Password + " TEXT)";

    //ADDRESS TABLE CREATE STATEMENTS
    private static final String CREATE_TABLE_ADDRESS = "CREATE TABLE " +
            TABLE_ADDRESS + "(" +
            ADDRESS_Id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ADDRESS_District + " TEXT, " +
            ADDRESS_USER_ID + " INTEGER, " +
            " FOREIGN KEY (" + ADDRESS_USER_ID + ") REFERENCES " +
            TABLE_USER + "(" + USER_Id + ") )";


    //ORDER TABLE CREATE STATEMENTS
    private static final String CREATE_TABLE_ORDER = "CREATE TABLE " +
            TABLE_ORDER + "(" +
            ORDER_Id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ORDER_District + " TEXT, "+
            ORDER_Number + " INTEGER, " +
            ORDER_Hour + " TIME, " +
            ORDER_Date + " DATETIME," +
            ORDER_Description + " TEXT, " +
            ORDER_SUBDOMAIN_ID + " INTEGER, " +
            ORDER_USER_ID + " INTEGER, " +
            " FOREIGN KEY (" + ORDER_USER_ID + ") REFERENCES " +
            TABLE_USER + "(" + USER_Id + ") , FOREIGN KEY (" + ORDER_SUBDOMAIN_ID + ") REFERENCES "
            + TABLE_SUBDOMAIN + "(" + DOMAIN_Id + ") )";


    //DOMAIN TABLE CREATE STATEMENTS
    private static final String CREATE_TABLE_DOMAIN = "CREATE TABLE " +
            TABLE_DOMAIN + "(" +
            DOMAIN_Id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            DOMAIN_Name + " TEXT, "+
            DOMAIN_Image + " INTEGER, " +
            DOMAIN_Description + " TEXT )";

    //SUBDOMAIN TABLE CREATE STATEMENTS
    private static final String CREATE_TABLE_SUBDOMAIN = "CREATE TABLE " +
            TABLE_SUBDOMAIN + "(" +
            SUBDOMAIN_Id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            SUBDOMAIN_Libelle + " TEXT, " +
            SUBDOMAIN_DOMAIN_ID + " INTEGER, " +
            " FOREIGN KEY (" +
            SUBDOMAIN_DOMAIN_ID + ") REFERENCES " +
            TABLE_DOMAIN + "(" + DOMAIN_Id +") )";


    /*NOTIFICATION TABLE CREATE STATEMENTS
    private static final String CREATE_TABLE_NOTIFICATION = "CREATE TABLE " +
            TABLE_NOTIFICATION + "(" +
            NOTIFICATION_Id + " INTEGER PRIMARY KEY," +
            NOTIFICATION_Title + " TEXT, "+
            NOTIFICATION_Message + " INTEGER, " +
            NOTIFICATION_Link + " TEXT, " +
            NOTIFICATION_Date + " DATETIME )"; */



    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_ADDRESS);
        db.execSQL(CREATE_TABLE_ORDER);
        db.execSQL(CREATE_TABLE_DOMAIN);
        db.execSQL(CREATE_TABLE_SUBDOMAIN);
        // db.execSQL(CREATE_TABLE_NOTIFICATION);
    }

    public void addDomain(String libelle, int image, String description){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DOMAIN_Name, libelle);
        contentValues.put(DOMAIN_Image, image);
        contentValues.put(DOMAIN_Description, description);
        dbWrite.insert(TABLE_DOMAIN, null, contentValues);
    }

    public void clearDomainTable(){
        dbWrite.execSQL("DELETE FROM "+ TABLE_DOMAIN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADDRESS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DOMAIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUBDOMAIN);
        //  db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTIFICATION);

        onCreate(db);

    }

    private String getDateTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    public long RegisterUser(User user){
        ContentValues values = new ContentValues();
        values.put(USER_Id, user.getId());
        values.put(USER_Image, user.getImage());
        values.put(USER_Name, user.getName());
        values.put(USER_Email, user.getEmail());
        values.put(USER_Number, user.getNumber());
        values.put(USER_Password, user.getPasword());

        //insert row
        long user_id = dbWrite.insert(TABLE_USER, null, values);

        return user_id;
    }

    public long SaveOrder(Order order){
        ContentValues values = new ContentValues();
        values.put(ORDER_Id, order.getId());
        values.put(ORDER_District, order.getDistrict());
        values.put(ORDER_Date, order.getDate());
        values.put(ORDER_Hour, order.getHour());
        values.put(ORDER_Number, order.getNumber());
        values.put(ORDER_Description, order.getDescription());
        values.put(ORDER_USER_ID, order.getIdUser());
        values.put(ORDER_SUBDOMAIN_ID, order.getIdSubDomain());

        //insert row
        long order_id = dbWrite.insert(TABLE_ORDER, null, values);

        return order_id;
    }

    public User LogUser(String email, String password){
        String selectQuery = "SELECT * FROM " +
                TABLE_USER + " WHERE " +
                USER_Email + " = " + email + "AND"+
                USER_Password + " = " + password;
        String LOG = "";
        Log.e(LOG, selectQuery );

        Cursor c = dbRead.rawQuery(selectQuery, null);

        if(c != null){
            c.moveToFirst();
        }

        User u = new User();

        u.setId(c.getInt(c.getColumnIndex(USER_Id)));
        u.setName(c.getString(c.getColumnIndex(USER_Name)));
        u.setEmail(c.getString(c.getColumnIndex(USER_Email)));
        u.setPasword(c.getString(c.getColumnIndex(USER_Password)));
        u.setNumber(c.getInt(c.getColumnIndex(USER_Number)));
        u.setImage(c.getInt(c.getColumnIndex(USER_Image)));

        return u;
    }

    public List<Domain> DisplayDomain(){
        List<Domain> domainList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " +
                TABLE_DOMAIN;
        String LOG = "DOMAIN";
        Cursor c = dbRead.rawQuery(selectQuery, null);

        if(c != null){
            c.moveToFirst();
        }
        while(!c.isAfterLast()){
            Domain d = new Domain();
            d.setId(c.getInt(c.getColumnIndex(DOMAIN_Id)));
            d.setName(c.getString(c.getColumnIndex(DOMAIN_Name)));
            d.setDescription(c.getString(c.getColumnIndex(DOMAIN_Description)));
            d.setImage(c.getInt(c.getColumnIndex(DOMAIN_Image)));
            domainList.add(d);
            c.moveToNext();
        }
        Log.e(LOG, domainList.toString());

        return domainList;
    }

    public List<Subdomain> DisplaySubDomain(int domain_id){
        List<Subdomain> subDomainList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " +
                TABLE_SUBDOMAIN + "WHERE" +
                SUBDOMAIN_DOMAIN_ID + " = " + domain_id;
        String LOG = "SUBDOMAIN";

        Cursor c = dbRead.rawQuery(selectQuery, null);

        if(c != null){
            c.moveToFirst();
        }

        while(!c.isAfterLast()){
            Subdomain d = new Subdomain();
            d.setId(c.getInt(c.getColumnIndex(SUBDOMAIN_Id)));
            d.setLibelle(c.getString(c.getColumnIndex(SUBDOMAIN_Libelle)));
            d.setIdDomain(c.getInt(c.getColumnIndex(SUBDOMAIN_DOMAIN_ID)));
            c.moveToNext();
        }
        Log.e(LOG, subDomainList.toString());

        return subDomainList;
    }

    public List<Address> AddressHistory(int addressUser_id){
        List<Address> addressList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " +
                TABLE_ADDRESS + " WHERE " +
                ADDRESS_USER_ID + " = " + addressUser_id;
        String LOG = "ADDRESS";

        Cursor c = dbRead.rawQuery(selectQuery, null);

        if(c != null){
            c.moveToFirst();
        }

        while(!c.isAfterLast()){
            Address a = new Address();
            a.setId(c.getInt(c.getColumnIndex(ADDRESS_Id)));
            a.setDistrict(c.getString(c.getColumnIndex(ADDRESS_District)));
            a.setIdUser(c.getInt(c.getColumnIndex(ADDRESS_USER_ID)));
            c.moveToNext();
        }
        Log.e(LOG, addressList.toString());

        return addressList;
    }

    public List<Order> OrderHistory(int orderUser_id){
        List<Order> orderList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " +
                TABLE_ORDER + " WHERE " +
                ORDER_USER_ID + " = " + orderUser_id;
        String LOG = "ORDER";

        Cursor c = dbRead.rawQuery(selectQuery, null);

        if(c != null){
            c.moveToFirst();
        }

        while(!c.isAfterLast()){
            Order o = new Order();
            o.setId(c.getInt(c.getColumnIndex(ORDER_Id)));
            o.setDistrict(c.getString(c.getColumnIndex(ORDER_District)));
            o.setDate(c.getString(c.getColumnIndex(ORDER_Date)));
            o.setHour(c.getInt(c.getColumnIndex(ORDER_Hour)));
            o.setNumber(c.getInt(c.getColumnIndex(ORDER_Number)));
            o.setDescription(c.getString(c.getColumnIndex(ORDER_Description)));
            o.setIdUser(c.getInt(c.getColumnIndex(ORDER_USER_ID)));
            o.setIdSubDomain(c.getInt(c.getColumnIndex(ORDER_SUBDOMAIN_ID)));
            c.moveToNext();
        }
        Log.e(LOG, orderList.toString());

        return orderList;
    }

}