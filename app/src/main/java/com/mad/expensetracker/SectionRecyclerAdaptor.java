package com.mad.expensetracker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SectionRecyclerAdaptor extends RecyclerView.Adapter<SectionRecyclerAdaptor.SectionViewHolder> {

    List<Section> sectionList;

    public SectionRecyclerAdaptor(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    @NonNull
    @Override
    public SectionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.section_row, viewGroup, false);
        return new SectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SectionViewHolder sectionViewHolder, int position) {
        Section section = sectionList.get(position);
        String sectionName = section.getSectionName();
        List<Section.SectionChildCard> items = section.getSectionItems();

        sectionViewHolder.sectionName.setText(sectionName);

        SectionChildRecyclerAdaptor childRecyclerAdaptor = new SectionChildRecyclerAdaptor(items);
        sectionViewHolder.childRecycler.setAdapter(childRecyclerAdaptor);
    }

    @Override
    public int getItemCount() {
        return sectionList.size();
    }

    class SectionViewHolder extends RecyclerView.ViewHolder{
        TextView sectionName;
        RecyclerView childRecycler;
        public SectionViewHolder(@NonNull View itemView) {
            super(itemView);

            sectionName = itemView.findViewById(R.id.sectionDate);
            childRecycler = itemView.findViewById(R.id.childRecyclerView);
        }
    }
}
