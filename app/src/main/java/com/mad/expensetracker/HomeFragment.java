package com.mad.expensetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mad.expensetracker.Models.ExpenseRecord;
import com.mad.expensetracker.data.MyDBHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    Activity context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    RecyclerView recyclerView;
    RecentListRecyclerAdaptor recyclerAdaptor;

//    List to store the respective row data which will come from database
    List<SingleRecentCardRow> expenseRowList;

    public void onStart(){
        super.onStart();

        Button viewAllButton = (Button) context.findViewById(R.id.viewAll);

        TextView expCurr = context.findViewById(R.id.expCurr);
        TextView incCurr = context.findViewById(R.id.textView8);

        viewAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewAllActivity.class);
                startActivity(intent);
            }
        });

        expenseRowList = new ArrayList<>();
        MyDBHandler db = new MyDBHandler(context);



        recyclerView = context.findViewById(R.id.recentList);

//        As we made constructor to map icons, dates etc to particular row!
        recyclerAdaptor = new RecentListRecyclerAdaptor(expenseRowList);

        recyclerView.setAdapter(recyclerAdaptor);

        List<ExpenseRecord> allRecords = db.getTenRecords();

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
                case "Print":
                    expenseTypeIcon = R.drawable.print;
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
        }

        int exp = db.getCurrentExpense();
        int inc = db.getCurrentIncome();

        String totalExp = "- ₹";
        String totalInc = "+ ₹";
//        Log.d("EXPTAG", "onStart: "+exp);

        expCurr.setText(totalExp+String.valueOf(exp));
        incCurr.setText(totalInc+String.valueOf(inc));

//        expenseRowList.add(new SingleRecentCardRow("College To Home","Transport","- ₹100","3 Feb, 2023",R.drawable.transport));
//        expenseRowList.add(new SingleRecentCardRow("Akshat Birthday","Celebration","- ₹250","11 Jan, 2023",R.drawable.celebration));
//        expenseRowList.add(new SingleRecentCardRow("Mobile Recharge","Bill","- ₹700","12 Feb, 2023",R.drawable.bill));
//        expenseRowList.add(new SingleRecentCardRow("MAD Xerox","Print","- ₹100","10 Apr, 2023",R.drawable.print));
//        expenseRowList.add(new SingleRecentCardRow("Subway","Snacks","- ₹120","27 Jan, 2023",R.drawable.snack));
//        expenseRowList.add(new SingleRecentCardRow("New Charger","Shopping","- ₹400","21 Feb, 2023",R.drawable.shopping));
//        expenseRowList.add(new SingleRecentCardRow("Coffee","Drinks","- ₹20","22 Feb, 2023",R.drawable.chai_coffee));

        DividerItemDecoration divider = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);
    }

}