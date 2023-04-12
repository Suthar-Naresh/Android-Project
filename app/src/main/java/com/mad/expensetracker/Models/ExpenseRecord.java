package com.mad.expensetracker.Models;

public class ExpenseRecord {
    private int id;
    private String title;
    private String amount;
    private String type;
    private String timestamp;
    private String date;
    private String description;
    private String category;

    public ExpenseRecord(String title, String amount, String type, String timestamp, String date, String description, String category) {
        this.title = title;
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
        this.date = date;
        this.description = description;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getTimestamp() {
        return timestamp;
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
