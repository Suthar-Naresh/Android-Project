package com.mad.expensetracker;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Section {
    private String sectionName;
    private List<SectionChildCard> sectionItems;

    @Override
    public String toString() {
        return "Section{" +
                "sectionName='" + sectionName + '\'' +
                ", sectionItems=" + sectionItems +
                '}';
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public List<SectionChildCard> getSectionItems() {
        return sectionItems;
    }

    public void setSectionItems(List<SectionChildCard> sectionItems) {
        this.sectionItems = sectionItems;
    }


    public Section(String sectionName, List<SectionChildCard> sectionItems) {
        this.sectionName = sectionName;
        this.sectionItems = sectionItems;
    }

    class SectionChildCard{
        int expenseTypeIcon;
        String cardExpenseTitle, cardExpenseType, cardExpenseAmount, cardExpenseDate;

        public SectionChildCard(int expenseTypeIcon, String cardExpenseTitle, String cardExpenseType, String cardExpenseAmount, String cardExpenseDate) {
            this.expenseTypeIcon = expenseTypeIcon;
            this.cardExpenseTitle = cardExpenseTitle;
            this.cardExpenseType = cardExpenseType;
            this.cardExpenseAmount = cardExpenseAmount;
            this.cardExpenseDate = cardExpenseDate;
        }
    }
}
