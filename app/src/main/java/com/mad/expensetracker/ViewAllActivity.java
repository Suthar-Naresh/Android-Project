package com.mad.expensetracker;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    Button imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        getSupportActionBar().setTitle("View All");

        imageButton = (Button) findViewById(R.id.iconButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet();
            }
        });

//        initData();
        viewAllListRecyclerView = findViewById(R.id.viewAllList);
        SectionRecyclerAdaptor mainRecyclerAdaptor = new SectionRecyclerAdaptor(sectionList);
        viewAllListRecyclerView.setAdapter(mainRecyclerAdaptor);

        viewAllListRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

//    probably database fetch?

    List<Section> sectionList = new ArrayList<>();
    RecyclerView viewAllListRecyclerView;

    private void initData(){
        String section1 = "1 Jan, 2023";
        List<Section.SectionChildCard> section1List = new ArrayList<>();
        section1List.add(new Section.SectionChildCard(R.drawable.bill,"Mobile Recharge","700","1 Jan, 02:12 PM"));
        section1List.add(new Section.SectionChildCard(R.drawable.snack,"Subway","120","1 Jan, 05:00 PM"));

//        String section2 = "25 Apr, 2023";
//        List<Section.SectionChildCard> section2List = new ArrayList<>();
//        section2List.add("Sanju Birthday");
//
//        String section3 = "11 Jan, 2023";
//        List<Section.SectionChildCard> section3List = new ArrayList<>();
//        section3List.add("College To Home");
//        section3List.add("Mobile Recharge");
//        section3List.add("CNS Xerox");
//        section3List.add("MAD Xerox");

//        sectionList.add(new Section(section1, section1List));
//        sectionList.add(new Section(section2, section2List));
//        sectionList.add(new Section(section3, section3List));
    }

    private void showBottomSheet(){
        final Dialog sheet = new Dialog(this);
        sheet.requestWindowFeature(Window.FEATURE_NO_TITLE);
        sheet.setContentView(R.layout.bottom_modal_sheet);

//        Set on click on every element of sheet in order to make them interactive!

        sheet.show();
        sheet.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        sheet.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        sheet.getWindow().getAttributes().windowAnimations = R.style.BottomModalSheetAnimation;
        sheet.getWindow().setGravity(Gravity.BOTTOM);
    }
}