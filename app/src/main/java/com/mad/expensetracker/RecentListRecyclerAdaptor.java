package com.mad.expensetracker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecentListRecyclerAdaptor extends RecyclerView.Adapter<RecentListRecyclerAdaptor.RecentCardRow>{

    @NonNull
    @Override
    public RecentCardRow onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recent_card_item, parent, false);

        RecentCardRow recentCardRow = new RecentCardRow(view);

        return recentCardRow;
    }

    @Override
    public void onBindViewHolder(@NonNull RecentCardRow recentCardRow, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
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
