package com.mad.expensetracker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecentListRecyclerAdaptor extends RecyclerView.Adapter<RecentListRecyclerAdaptor.RecentCardRow>{

//    To make constructor; so that we can map the values to incoming data!
    List<String> cardExpenseTitles, cardExpenseTypes, cardExpenseAmounts, cardExpenseDates;
    List<Integer> expenseTypeIcons;

    public RecentListRecyclerAdaptor(List<String> cardExpenseTitles, List<String> cardExpenseTypes, List<String> cardExpenseAmounts, List<String> cardExpenseDates, List<Integer> expenseTypeIcons) {
        this.cardExpenseTitles = cardExpenseTitles;
        this.cardExpenseTypes = cardExpenseTypes;
        this.cardExpenseAmounts = cardExpenseAmounts;
        this.cardExpenseDates = cardExpenseDates;
        this.expenseTypeIcons = expenseTypeIcons;
    }

    @NonNull
    @Override
    public RecentCardRow onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recent_card_item, parent, false);

        RecentCardRow recentCardRow = new RecentCardRow(view);

        return recentCardRow;
    }

//    Used to map the data to row
    @Override
    public void onBindViewHolder(@NonNull RecentCardRow recentCardRowHolder, int position) {
/*
        recentCardRowHolder.expenseTypeIcon.setImageResource(R.drawable.transport);
        recentCardRowHolder.cardExpenseTitle.setText("College To Home");
        recentCardRowHolder.cardExpenseType.setText("Transport");
        recentCardRowHolder.cardExpenseAmount.setText("- ₹100");
        recentCardRowHolder.cardExpenseDate.setText("31 Jan, 2023");
 */

//        Setting every row data on the basis of lists provided using position of row i.e. from db?
        recentCardRowHolder.expenseTypeIcon.setImageResource(expenseTypeIcons.get(position));
        recentCardRowHolder.cardExpenseTitle.setText(cardExpenseTitles.get(position));
        recentCardRowHolder.cardExpenseType.setText(cardExpenseTypes.get(position));
        recentCardRowHolder.cardExpenseAmount.setText(cardExpenseAmounts.get(position));
        recentCardRowHolder.cardExpenseDate.setText(cardExpenseDates.get(position));
    }

    @Override
    public int getItemCount() {
//        return 10;
        return cardExpenseAmounts.size();
    }

    class RecentCardRow extends RecyclerView.ViewHolder{

//        Accessing all the views present in a single recent card from xml

        ImageView expenseTypeIcon;
        TextView cardExpenseTitle, cardExpenseType, cardExpenseAmount, cardExpenseDate;

        public RecentCardRow(@NonNull View itemView) {
            super(itemView);

            expenseTypeIcon = itemView.findViewById(R.id.expenseTypeIcon);
            cardExpenseTitle = itemView.findViewById(R.id.cardExpenseTitle);
            cardExpenseType = itemView.findViewById(R.id.cardExpenseType);
            cardExpenseAmount = itemView.findViewById(R.id.cardExpenseAmount);
            cardExpenseDate = itemView.findViewById(R.id.cardExpenseDate);


        }
    }
}
