package com.example.eventproject;

// This code is by Eric. Please ask if you have questions.

public class Post {

    private String title;
    private String description;
    private String location;
    private int month;
    private int day;
    private int year;
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;
    private int openSpots;
    private String tag;

    public Post(String title) {
        this.title = title;
    }

    //setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    //setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    //setter for location
    public void setLocation(String location) {
        this.location = location;
    }

    //setter for month
    public void setMonth(int month) {
        this.month = (month);
    }

    //setter for day
    public void setDay(int day) {
        this.day = day;
    }

    //setter for year
    public void setYear(int year) {
        this.year = year;
    }

    //setter for starting hour
    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    //setter for starting minute
    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    //setter for ending hour
    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    //setter for ending minutes
    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

    //setter for open spots
    public void setOpenSpots(int openSpots) {
        this.openSpots = openSpots;
    }

    //setter for tag
    public void setTag(String tag) {this.tag = tag; }

    //getter for title
    public String getTitle() {
        return title;
    }

    //getter for description
    public String getDescription() {
        return description;
    }

    //getter for location
    public String getLocation() {
        return location;
    }

    //getter for month
    public int getMonth() {
        return month;
    }
    //getter for day
    public int getDay() {
        return day;
    }

    //getter for year
    public int getYear() {
        return year;
    }

    //getter for starting hour
    public int getStartHour() {
        return startHour;
    }

    //getter for starting minute
    public int getStartMinute() {
        return startMinute;
    }

    //getter for ending hour
    public int getEndHour() {
        return endHour;
    }

    //getter for ending minute
    public int getEndMinute() {
        return endMinute;
    }

    //getter for open spots
    public int getOpenSpots() {
        return openSpots;
    }

    //getter for tag
    public String getTag() {
        return tag;
    }
}
