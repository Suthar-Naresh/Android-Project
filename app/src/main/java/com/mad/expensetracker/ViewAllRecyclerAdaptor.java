package com.mad.expensetracker;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ViewAllRecyclerAdaptor extends RecyclerView.Adapter<ViewAllRecyclerAdaptor.RecentCardRow>{

    List<SingleRecentCardRow> expenseRowList;

    public ViewAllRecyclerAdaptor(List<SingleRecentCardRow> expenseRowList) {
        this.expenseRowList = expenseRowList;
    }

    @NonNull
    @Override
    public RecentCardRow onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recent_card_item, parent, false);

        RecentCardRow recentCardRow = new RecentCardRow(view);

        return recentCardRow;
    }

    @Override
    public void onBindViewHolder(@NonNull RecentCardRow recentCardRowHolder, int position) {

        recentCardRowHolder.expenseTypeIcon.setImageResource(expenseRowList.get(position).expenseTypeIcon);
        recentCardRowHolder.cardExpenseTitle.setText(expenseRowList.get(position).cardExpenseTitle);
        recentCardRowHolder.cardExpenseType.setText(expenseRowList.get(position).cardExpenseType);
        recentCardRowHolder.cardExpenseAmount.setText(expenseRowList.get(position).cardExpenseAmount);
        recentCardRowHolder.cardExpenseDate.setText(expenseRowList.get(position).cardExpenseDate);

        String amt = expenseRowList.get(position).cardExpenseAmount;
        if(Character.compare(amt.charAt(0),'+')==0){
            recentCardRowHolder.cardExpenseAmount.setTextColor(Color.parseColor("#31CD38"));
        }
    }

    @Override
    public int getItemCount() {
        return expenseRowList.size();
    }

    class RecentCardRow extends RecyclerView.ViewHolder{

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
