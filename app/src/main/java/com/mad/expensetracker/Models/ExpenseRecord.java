package com.mad.expensetracker.Models;

public class ExpenseRecord {
    private int id;
    private String title;
    private int amount;
    private String type;
    private String date;
    private String description;
    private String category;

    public ExpenseRecord(String title, int amount, String type, String date, String description, String category) {
        this.title = title;
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.description = description;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public int getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
}