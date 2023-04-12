package com.mad.expensetracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import com.mad.expensetracker.Models.ExpenseRecord;
import com.mad.expensetracker.Params.Params;
import com.mad.expensetracker.R;
import com.mad.expensetracker.SingleRecentCardRow;

import java.util.ArrayList;
import java.util.List;

public class MyDBHandler extends SQLiteOpenHelper {
    public MyDBHandler(Context ctx) {
        super(ctx, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + Params.TABLE_NAME +
                "(" +
                Params.KEY_ID + " INTEGER PRIMARY KEY, " +
                Params.KEY_TITLE + " TEXT, " +
                Params.KEY_AMOUNT + " INTEGER, " +
                Params.KEY_TYPE + " TEXT, " +
                Params.KEY_DATE + " TEXT, " +
                Params.KEY_DESCRIPTION + " TEXT, " +
                Params.KEY_CATEGORY + " TEXT" +
                ")";

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

        // Inserting into DB!!!!!
        db.insert(Params.TABLE_NAME, null, values);
//        Log.d("TAG", "addNewExpense: WORKING!!!");
        db.close();
    }

    public List<ExpenseRecord> getTenRecords(){
//        Log.d("fetch", "getAllRecords: I'm here!!");
        List<ExpenseRecord> allRecords = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Query to get all records
        String query = "SELECT * FROM " + Params.TABLE_NAME + " ORDER BY " + Params.KEY_ID + " DESC LIMIT 10";
        Cursor cursor = db.rawQuery(query, null);

        String title, type, date, description, category;
        int amount;

        if(cursor.moveToFirst()){
            do{
                title = cursor.getString(cursor.getColumnIndex(Params.KEY_TITLE));
                type = cursor.getString(cursor.getColumnIndex(Params.KEY_TYPE));
                category = cursor.getString(cursor.getColumnIndex(Params.KEY_CATEGORY));
                amount = cursor.getInt(cursor.getColumnIndex(Params.KEY_AMOUNT));
                date = cursor.getString(cursor.getColumnIndex(Params.KEY_DATE));
                description = cursor.getString(cursor.getColumnIndex(Params.KEY_DESCRIPTION));

//                SingleRecentCardRow cardRow = new SingleRecentCardRow(cardExpenseTitle,cardExpenseType,cardExpenseAmount,cardExpenseDate,expenseTypeIcon);

                allRecords.add(new ExpenseRecord(title,amount,type,date,description,category));
            }while (cursor.moveToNext());
        }
        return allRecords;
    }

    public List<ExpenseRecord> getAllRecords(){
        Log.d("fetch", "getAllRecords: I'm here!!");
        List<ExpenseRecord> allRecords = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Query to get all records
        String query = "SELECT * FROM " + Params.TABLE_NAME + " ORDER BY " + Params.KEY_ID + " DESC";
        Cursor cursor = db.rawQuery(query, null);

        String title, type, date, description, category;
        int amount;

        if(cursor.moveToFirst()){
            do{
                title = cursor.getString(cursor.getColumnIndex(Params.KEY_TITLE));
                type = cursor.getString(cursor.getColumnIndex(Params.KEY_TYPE));
                category = cursor.getString(cursor.getColumnIndex(Params.KEY_CATEGORY));
                amount = cursor.getInt(cursor.getColumnIndex(Params.KEY_AMOUNT));
                date = cursor.getString(cursor.getColumnIndex(Params.KEY_DATE));
                description = cursor.getString(cursor.getColumnIndex(Params.KEY_DESCRIPTION));

//                SingleRecentCardRow cardRow = new SingleRecentCardRow(cardExpenseTitle,cardExpenseType,cardExpenseAmount,cardExpenseDate,expenseTypeIcon);

                allRecords.add(new ExpenseRecord(title,amount,type,date,description,category));
            }while (cursor.moveToNext());
        }
        return allRecords;
    }

    public List<ExpenseRecord> getIncomeRecord(){
        List<ExpenseRecord> allRecords = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Query to get all records
        String query = "SELECT * FROM " + Params.TABLE_NAME + " WHERE "+Params.KEY_TYPE+"=\"Income\" ORDER BY " + Params.KEY_ID + " DESC";
        Cursor cursor = db.rawQuery(query, null);

        String title, type, date, description, category;
        int amount;

        if(cursor.moveToFirst()){
            do{
                title = cursor.getString(cursor.getColumnIndex(Params.KEY_TITLE));
                type = cursor.getString(cursor.getColumnIndex(Params.KEY_TYPE));
                category = cursor.getString(cursor.getColumnIndex(Params.KEY_CATEGORY));
                amount = cursor.getInt(cursor.getColumnIndex(Params.KEY_AMOUNT));
                date = cursor.getString(cursor.getColumnIndex(Params.KEY_DATE));
                description = cursor.getString(cursor.getColumnIndex(Params.KEY_DESCRIPTION));

//                SingleRecentCardRow cardRow = new SingleRecentCardRow(cardExpenseTitle,cardExpenseType,cardExpenseAmount,cardExpenseDate,expenseTypeIcon);

                allRecords.add(new ExpenseRecord(title,amount,type,date,description,category));
            }while (cursor.moveToNext());
        }
        return allRecords;
    }

    public List<ExpenseRecord> getExpenseRecord(){
        List<ExpenseRecord> allRecords = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Query to get all records
        String query = "SELECT * FROM " + Params.TABLE_NAME + " WHERE "+Params.KEY_TYPE+"=\"Expense\" ORDER BY " + Params.KEY_ID + " DESC";
        Cursor cursor = db.rawQuery(query, null);

        String title, type, date, description, category;
        int amount;

        if(cursor.moveToFirst()){
            do{
                title = cursor.getString(cursor.getColumnIndex(Params.KEY_TITLE));
                type = cursor.getString(cursor.getColumnIndex(Params.KEY_TYPE));
                category = cursor.getString(cursor.getColumnIndex(Params.KEY_CATEGORY));
                amount = cursor.getInt(cursor.getColumnIndex(Params.KEY_AMOUNT));
                date = cursor.getString(cursor.getColumnIndex(Params.KEY_DATE));
                description = cursor.getString(cursor.getColumnIndex(Params.KEY_DESCRIPTION));

//                SingleRecentCardRow cardRow = new SingleRecentCardRow(cardExpenseTitle,cardExpenseType,cardExpenseAmount,cardExpenseDate,expenseTypeIcon);

                allRecords.add(new ExpenseRecord(title,amount,type,date,description,category));
            }while (cursor.moveToNext());
        }
        return allRecords;
    }
}
