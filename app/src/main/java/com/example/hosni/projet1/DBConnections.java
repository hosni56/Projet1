package com.example.hosni.projet1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by HOSNI on 02/04/2016.
 */
public class DBConnections extends SQLiteOpenHelper {
    public static final String  DbName="abc.db";
    public static final int Verson=1;
    public  DBConnections(Context context){
        super(context,DbName,null,Verson);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table IF NOT EXISTS admin (id INTEGER primary key,name TEXT)");
      //  db.execSQL("Create table IF NOT EXISTS adminproduct (adminid INTEGER primary key,productName TEXT)");
      //  db.execSQL("Create VIEW IF NOT EXISTS Adminproduct  as select name,productName,admin.id from admin left join adminproduct on admin.id=adminproduct.adminid");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if EXISTS admin");
     //  db.execSQL("Drop table if EXISTS adminproduct");
        onCreate(db);
    }

    public void  InsertRowAdmin(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", name);

        db.insert("admin", null, contentValues);

    }
   /* public void  InsertRowprocut(String name, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("productName", name);
        contentValues.put("adminid", id);
        db.insert("adminproduct", null, contentValues);
    }
*/
    public ArrayList getAllrecord()
    {
        ArrayList array_list = new ArrayList();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from admin", null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex("id"))+":"+res.getString(res.getColumnIndex("name")));
            res.moveToNext();
        }
        return array_list;
    }

//



    public void deleteR (Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from admin where id="+ Integer.toString(id));
        // db.delete("admin", "id = ?,name=? ", new String[] { Integer.toString(id) ,"hussien"});
    }
    public void  updateR (String name,Integer id )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update admin set name='" + name+ "' where id="+ Integer.toString(id));
  /* ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        db.update("admin", contentValues, "id = ? ", new String[] { Integer.toString(id) } );*//**//**/

    }
}