package com.mad.expensetracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import com.mad.expensetracker.Models.ExpenseRecord;
import com.mad.expensetracker.Params.Params;

public class MyDBHandler extends SQLiteOpenHelper {
    public MyDBHandler(Context ctx) {
        super(ctx, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + Params.DB_NAME +
                "(" +
                Params.KEY_ID + " INTEGER PRIMARY KEY, " +
                Params.KEY_TITLE + " TEXT, " +
                Params.KEY_AMOUNT + " INTEGER, " +
                Params.KEY_TYPE + " TEXT, " +
                Params.KEY_TIMESTAMP + " TEXT, " +
                Params.KEY_DATE + " TEXT, " +
                Params.KEY_DESCRIPTION + " TEXT, " +
                Params.KEY_CATEGORY + " TEXT" +
                ")";

        Log.d("dbdb:", "working... --> "+create);
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addNewExpense(ExpenseRecord expenseRecord){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_TITLE, expenseRecord.getTitle());
        values.put(Params.KEY_AMOUNT, expenseRecord.getAmount());
        values.put(Params.KEY_CATEGORY, expenseRecord.getCategory());
        values.put(Params.KEY_TYPE, expenseRecord.getType());
        values.put(Params.KEY_DESCRIPTION, expenseRecord.getDescription());
        values.put(Params.KEY_DATE, expenseRecord.getDate());
        values.put(Params.KEY_TIMESTAMP, expenseRecord.getTimestamp());
    }
}
