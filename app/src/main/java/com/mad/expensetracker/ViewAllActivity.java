package com.mad.expensetracker;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mad.expensetracker.Models.ExpenseRecord;
import com.mad.expensetracker.data.MyDBHandler;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    Button filterAll,filterIncome,filterExpense;

    RecyclerView recyclerView;
    ViewAllRecyclerAdaptor recyclerAdaptor;
    List<SingleRecentCardRow> expenseRowList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        getSupportActionBar().setTitle("View All");

        filterAll = findViewById(R.id.buttonAll);
        filterIncome = findViewById(R.id.buttonIncome);
        filterExpense = findViewById(R.id.buttonExpense);

        filterAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterRecords(0);
            }
        });

        filterIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterRecords(1);
            }
        });

        filterExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterRecords(2);
            }
        });

        expenseRowList = new ArrayList<>();

        recyclerView = findViewById(R.id.viewAllList);

        filterRecords(0);

        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);
    }


    public void filterRecords(int filter){
        expenseRowList.clear();
        MyDBHandler db = new MyDBHandler(this);
        List<ExpenseRecord> allRecords = db.getAllRecords();;

        if(filter==0){
            // Nothing
        }else if(filter==1){
            allRecords = db.getIncomeRecord();
        }else if (filter==2){
            allRecords = db.getExpenseRecord();
        }

        for (ExpenseRecord i:allRecords){
            int expenseTypeIcon = R.drawable.other_2;

            switch (i.getCategory()){
                case "Other":
                    expenseTypeIcon = R.drawable.other_2;
                    break;
                case "Bill":
                    expenseTypeIcon = R.drawable.bill;
                    break;
                case "Celebration":
                    expenseTypeIcon = R.drawable.celebration;
                    break;
                case "Transport":
                    expenseTypeIcon = R.drawable.transport;
                    break;
                case "Snacks":
                    expenseTypeIcon = R.drawable.snack;
                    break;
                case "Shopping":
                    expenseTypeIcon = R.drawable.shopping;
                    break;
                case "Drinks":
                    expenseTypeIcon = R.drawable.chai_coffee;
                    break;
            }

            String amt = "";

            if (i.getType().equals("Income")){
                amt+="+ ₹";
            }else{
                amt+="- ₹";
            }
            amt+=String.valueOf(i.getAmount());

            expenseRowList.add(new SingleRecentCardRow(i.getTitle(),i.getCategory(),amt,i.getDate(),expenseTypeIcon));
            recyclerAdaptor = new ViewAllRecyclerAdaptor(expenseRowList);
            recyclerView.setAdapter(recyclerAdaptor);
        }
    }

    /*
    private void showBottomSheet(){
        final Dialog sheet = new Dialog(this);
        sheet.requestWindowFeature(Window.FEATURE_NO_TITLE);
        sheet.setContentView(R.layout.bottom_modal_sheet);
        sheet.show();
        sheet.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        sheet.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        sheet.getWindow().getAttributes().windowAnimations = R.style.BottomModalSheetAnimation;
        sheet.getWindow().setGravity(Gravity.BOTTOM);
    }
     */
}