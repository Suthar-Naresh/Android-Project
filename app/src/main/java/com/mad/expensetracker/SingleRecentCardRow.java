package com.mad.expensetracker;

public class SingleRecentCardRow{
    String cardExpenseTitle, cardExpenseType, cardExpenseAmount, cardExpenseDate;
    int expenseTypeIcon;

    public SingleRecentCardRow(String cardExpenseTitle, String cardExpenseType, String cardExpenseAmount, String cardExpenseDate, int expenseTypeIcon) {
        this.cardExpenseTitle = cardExpenseTitle;
        this.cardExpenseType = cardExpenseType;
        this.cardExpenseAmount = cardExpenseAmount;
        this.cardExpenseDate = cardExpenseDate;
        this.expenseTypeIcon = expenseTypeIcon;
    }
}