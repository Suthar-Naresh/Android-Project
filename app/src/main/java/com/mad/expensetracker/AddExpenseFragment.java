package com.mad.expensetracker;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mad.expensetracker.Models.ExpenseRecord;
import com.mad.expensetracker.data.MyDBHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddExpenseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddExpenseFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddExpenseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddExpenseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddExpenseFragment newInstance(String param1, String param2) {
        AddExpenseFragment fragment = new AddExpenseFragment();
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
        return inflater.inflate(R.layout.fragment_add_expense, container, false);
    }

    // Spinner selected value
    String selectedCategory = null;
    Spinner categorySpinner;
    String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

    public void onStart() {
        super.onStart();

        // Spinner setup
        categorySpinner = context.findViewById(R.id.expenseTypeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);
        categorySpinner.setOnItemSelectedListener(this);

        // Radio Group
        RadioGroup radioGroup = (RadioGroup) context.findViewById(R.id.radioGroup);

        // Setting current date and disabling so user can not select a date
        EditText expenseDate = context.findViewById(R.id.expenseDate);
        expenseDate.setText(currentDate);
        expenseDate.setFocusable(false);

        // Add expense click event
        Button addExpenseButton = context.findViewById(R.id.addExpense);
        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fetching information filled in the form
                EditText expenseTitle = context.findViewById(R.id.expenseTitle);
                String expenseRecordTitle = expenseTitle.getText().toString().trim();

                EditText expenseAmount = context.findViewById(R.id.expenseAmount);
                String expenseRecordAmount = expenseAmount.getText().toString().trim();

                EditText expenseDate = context.findViewById(R.id.expenseDate);
                String expenseRecordDate = expenseDate.getText().toString().trim();

                EditText expenseDescription = context.findViewById(R.id.expenseDescription);
                String expenseRecordDescription = expenseDescription.getText().toString().trim();

                int radioID = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = context.findViewById(radioID);
                String expenseRecordType = radioButton.getText().toString();

//                String msg = expenseRecordTitle+" "+expenseRecordAmount+" "+selectedCategory+" "+expenseRecordType;
//                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

                addNewExpenseDB(expenseRecordTitle, expenseRecordAmount,expenseRecordDescription,expenseRecordType,selectedCategory);
            }
        });

        // Cancel click event
        Button cancelButton = context.findViewById(R.id.cancelExpense);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText expenseTitle = context.findViewById(R.id.expenseTitle);
                expenseTitle.setText("");

                EditText expenseAmount = context.findViewById(R.id.expenseAmount);
                expenseAmount.setText("");

                EditText expenseDescription = context.findViewById(R.id.expenseDescription);
                expenseDescription.setText("");

                RadioButton radioButton = context.findViewById(R.id.radioExpense);
                radioButton.setChecked(true);

                categorySpinner.setSelection(0);
            }
        });
    }

    public void addNewExpenseDB(String expenseRecordTitle, String expenseRecordAmount,String expenseRecordDescription,String expenseRecordType,String selectedCategory){
        if(TextUtils.isEmpty(expenseRecordTitle) ||  TextUtils.isEmpty(expenseRecordDescription) || TextUtils.isEmpty(expenseRecordType) || TextUtils.isEmpty(selectedCategory) || TextUtils.isEmpty(expenseRecordAmount)){
            Toast.makeText(context, "Please provide all information.", Toast.LENGTH_SHORT).show();
        }else{
            // Add to database and empty form
            //db stuff
            MyDBHandler db = new MyDBHandler(context);
            ExpenseRecord record = new ExpenseRecord(expenseRecordTitle,Integer.parseInt(expenseRecordAmount),expenseRecordType,currentDate,expenseRecordDescription,selectedCategory);
            db.addNewExpense(record);

            Toast.makeText(context, "Data Added!", Toast.LENGTH_SHORT).show();

            EditText expenseTitle = context.findViewById(R.id.expenseTitle);
            expenseTitle.setText("");

            EditText expenseAmount = context.findViewById(R.id.expenseAmount);
            expenseAmount.setText("");

            EditText expenseDescription = context.findViewById(R.id.expenseDescription);
            expenseDescription.setText("");

            RadioButton radioButton = context.findViewById(R.id.radioExpense);
            radioButton.setChecked(true);

            categorySpinner.setSelection(0);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedCategory = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), selectedCategory, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}