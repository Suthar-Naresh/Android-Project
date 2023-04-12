package com.mad.expensetracker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SectionChildRecyclerAdaptor extends RecyclerView.Adapter<SectionChildRecyclerAdaptor.SectionChildViewHolder> {

    List<Section.SectionChildCard> items;

    public SectionChildRecyclerAdaptor(List<Section.SectionChildCard> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public SectionChildViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.section_row_item, viewGroup, false);
        return new SectionChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SectionChildViewHolder sectionChildViewHolder, int position) {
//        sectionChildViewHolder.;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class SectionChildViewHolder extends RecyclerView.ViewHolder{
        TextView sectionItem;
        public SectionChildViewHolder(@NonNull View itemView) {
            super(itemView);
//            sectionItem = itemView.findViewById(R.id.);
        }
    }
}
