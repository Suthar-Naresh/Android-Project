package com.mad.expensetracker;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

//        This should be after setOnNavigationItemSelectedListener...
//        bottomNavigationView.setSelectedItemId(R.id.bottom_navigation_add_new_expense);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.bottom_navigation_add_new_expense);
    }

    HomeFragment homeFragment = new HomeFragment();
    AddExpenseFragment addExpenseFragment = new AddExpenseFragment();
    AnalyticsFragment analyticsFragment = new AnalyticsFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.bottom_navigation_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeFragment).commit();
                return true;
            case R.id.bottom_navigation_add_new_expense:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, addExpenseFragment).commit();
                return true;
            case R.id.bottom_navigation_analytics:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, analyticsFragment).commit();
                return true;
        }
        return false;
    }
}