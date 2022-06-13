/*package com.zyk.experiment1.dao.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zyk.experiment1.dao.FruitDao;
import com.zyk.experiment1.domain.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitDaoImpl implements FruitDao {

    private SQLiteDatabase db;
    private final SQLiteOpenHelper dbHelper;

    public FruitDaoImpl(Context context) {
        dbHelper = new SQLiteOpenHelper(context, "fruits.db", null, 1) {
            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL("create table fruits(f_id INTEGER not null PRIMARY KEY autoincrement,f_name text not null,f_info text,f_imageId INTEGER not null)");
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int i, int i1) {
                db.execSQL("DROP TABLE IF EXISTS "+"fruit.db");
                onCreate(db);
            }
        };
        db = dbHelper.getWritableDatabase();
    }

    @Override
    public long insert(Fruit fruit)
    {
        ContentValues newValue=new ContentValues();

        newValue.put("f_name",fruit.getName());
        newValue.put("f_imageId",fruit.getImageId());
        newValue.put("f_info",fruit.getInfo());

        return db.insert("fruits", null, newValue);
    }

    @Override
    public long deleteAll()
    {
        return db.delete("fruits", null, null);
    }

    @Override
    public List getAllFruit() {
        String sql = "select * from fruits";
        Cursor cursor = db.rawQuery(sql, null);
        List<Fruit> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id_index = cursor.getColumnIndex("f_id");
            int name_index = cursor.getColumnIndex("f_name");
            int imageId_index = cursor.getColumnIndex("f_imageId");
            int info_index = cursor.getColumnIndex("f_info");
            list.add(new Fruit(cursor.getInt(id_index),cursor.getString(name_index), cursor.getInt(imageId_index),cursor.getString(info_index)));
        }
        cursor.close();
        db.close();
        return list;
    }
}*/
