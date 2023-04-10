package com.mad.expensetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

//    Lists to store the respective row data which will come from database
    List<String> cardExpenseTitles, cardExpenseTypes, cardExpenseAmounts, cardExpenseDates;
    List<Integer> expenseTypeIcons;

    public void onStart(){
        super.onStart();

        Button viewAllButton = (Button) context.findViewById(R.id.viewAll);

        viewAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewAllActivity.class);
                startActivity(intent);
            }
        });

        //        Make databse call and set the values accordingly from database...

        cardExpenseTitles = new ArrayList<>();
        cardExpenseTypes = new ArrayList<>();
        cardExpenseAmounts = new ArrayList<>();
        cardExpenseDates = new ArrayList<>();
        expenseTypeIcons = new ArrayList<>();

        recyclerView = context.findViewById(R.id.recentList);
//        recyclerAdaptor = new RecentListRecyclerAdaptor();

//        As we made constructor to map icons, dates etc to particular row!
        recyclerAdaptor = new RecentListRecyclerAdaptor(cardExpenseTitles, cardExpenseTypes, cardExpenseAmounts, cardExpenseDates, expenseTypeIcons);

        recyclerView.setAdapter(recyclerAdaptor);

//        Adding data to lists
        cardExpenseTitles.add("College To Home");
        cardExpenseTypes.add("Transport");
        cardExpenseAmounts.add("- ₹100");
        cardExpenseDates.add("3 Feb, 2023");
        expenseTypeIcons.add(R.drawable.transport);

        cardExpenseTitles.add("Sanju Birthday");
        cardExpenseTypes.add("Celebration");
        cardExpenseAmounts.add("- ₹250");
        cardExpenseDates.add("25 Mar, 2023");
        expenseTypeIcons.add(R.drawable.birthday);

        cardExpenseTitles.add("Mobile Recharge");
        cardExpenseTypes.add("Bill");
        cardExpenseAmounts.add("- ₹700");
        cardExpenseDates.add("12 Feb, 2023");
        expenseTypeIcons.add(R.drawable.bill);

        cardExpenseTitles.add("MAD Xerox");
        cardExpenseTypes.add("Print");
        cardExpenseAmounts.add("- ₹100");
        cardExpenseDates.add("10 Apr, 2023");
        expenseTypeIcons.add(R.drawable.print);

        cardExpenseTitles.add("Subway");
        cardExpenseTypes.add("Snacks");
        cardExpenseAmounts.add("- ₹120");
        cardExpenseDates.add("27 Jan, 2023");
        expenseTypeIcons.add(R.drawable.snack);

        cardExpenseTitles.add("New Charger");
        cardExpenseTypes.add("Shopping");
        cardExpenseAmounts.add("- ₹400");
        cardExpenseDates.add("21 Feb, 2023");
        expenseTypeIcons.add(R.drawable.shopping);

        cardExpenseTitles.add("Coffee");
        cardExpenseTypes.add("Drinks");
        cardExpenseAmounts.add("- ₹20");
        cardExpenseDates.add("22 Feb, 2023");
        expenseTypeIcons.add(R.drawable.chai_coffee);

        DividerItemDecoration divider = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);
    }
}