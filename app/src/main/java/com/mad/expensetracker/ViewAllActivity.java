package com.mad.expensetracker;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

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