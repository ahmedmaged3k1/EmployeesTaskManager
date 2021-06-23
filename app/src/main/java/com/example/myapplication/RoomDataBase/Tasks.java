package com.example.myapplication.RoomDataBase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tasks implements Comparable<Tasks> {

    @PrimaryKey(autoGenerate = false)
    private int employeeID;
    private int priority ;
    private String taskTitle;
    private String  description;
    private String assigningDate;
    private String  endDate;
    private String  employeeName;

    public Tasks(int priority, String taskTitle, String description, String assigningDate, String endDate, String employeeName,int employeeID) {
        this.priority = priority;
        this.taskTitle = taskTitle;
        this.description = description;
        this.assigningDate = assigningDate;
        this.endDate = endDate;
        this.employeeName = employeeName;
        this.employeeID=employeeID;

    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssigningDate() {
        return assigningDate;
    }

    public void setAssigningDate(String assigningDate) {
        this.assigningDate = assigningDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }


    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }


    @Override
    public int compareTo(Tasks tasks) {
        if(this.priority<tasks.priority)return 1;
        else if(this.priority==tasks.priority) return 0;
        else return -1;

    }
}
