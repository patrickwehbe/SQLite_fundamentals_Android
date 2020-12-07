package com.example.martialartssqlite.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "martialArtsDatabase";
    private static final int DB_VERSION = 1;
    private static final String MARTIAL_ARTS_TABLE = "MartialArts";
    private static final String ID_KEY = "id";
    private static final String NAME_KEY = "name";
    private static final String PRICE_KEY = "price";
    private static final String COLOR_KEY = "color";

    public DBHandler(Context context){
        super(context, DB_NAME, null,DB_VERSION);

    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        String createDbSQL = "create table " + MARTIAL_ARTS_TABLE +
                "( " + ID_KEY + " integer primary key autoincrement " +
                ", " + NAME_KEY + " text" + ", " + PRICE_KEY + " real" +
                ", " + COLOR_KEY + " text" + " )";
        db.execSQL(createDbSQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + MARTIAL_ARTS_TABLE ) ;
        onCreate(db);
    }
    public void addMartialArt(MartialArt martialArt){
        SQLiteDatabase database = getWritableDatabase();
        String addMartialArtSQLCommand = "insert into " + MARTIAL_ARTS_TABLE + " values(null, '" + martialArt.getMartialArtname() +
                "', '" + martialArt.getMartialArtPrice() + "', '" + martialArt.getMartialArtColor() + "')";
        database.execSQL(addMartialArtSQLCommand);
        database.close();
    }
    public void deleteMartialArtObjectById(int id){
        SQLiteDatabase database = getWritableDatabase();
        String deleteMartialArtSQLCommand = "delete from " + MARTIAL_ARTS_TABLE + " where " + ID_KEY + " = " + id;
        database.execSQL(deleteMartialArtSQLCommand);
        database.close();
    }
    public void udpdateMartialArtObject(int id, String name, double price, String color){
        SQLiteDatabase database = getWritableDatabase();
        String updateMartialArtSQLCommand = "update " + MARTIAL_ARTS_TABLE + " set " + NAME_KEY + " = '" + name +
                "', " + PRICE_KEY + " = '" + price + "', " + COLOR_KEY + " = '" + color + "' " + "where " + ID_KEY + " = " + id;
        database.execSQL(updateMartialArtSQLCommand);
        database.close();

    }
    public ArrayList<MartialArt> returnAllmartialArtObjects(){
        SQLiteDatabase database = getWritableDatabase();
        String SQLQueryCommand = "select * from " + MARTIAL_ARTS_TABLE;
        Cursor cursor = database.rawQuery(SQLQueryCommand, null);
        ArrayList<MartialArt> martialArtsList = new ArrayList<>();

        while (cursor.moveToNext()){
            MartialArt currentMartialArt = new MartialArt(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                    cursor.getDouble(2), cursor.getString(3));
            martialArtsList.add(currentMartialArt);
        }
        database.close();
        return martialArtsList;

    }
    public MartialArt returnMartialArtObjectById(int id){
        SQLiteDatabase database = getWritableDatabase();
        String SQLQuerryCommand = "select * from " + MARTIAL_ARTS_TABLE + " where " + ID_KEY + " = " + id;
        Cursor cursor = database.rawQuery(SQLQuerryCommand, null);
        MartialArt martialArt = null;
        if (cursor.moveToFirst()){
            martialArt = new MartialArt(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                    cursor.getDouble(2), cursor.getString(3));
        }
        database.close();
        return martialArt;
    }

}
