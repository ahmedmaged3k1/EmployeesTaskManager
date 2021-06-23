package com.example.myapplication.RoomDataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class EmployeesRepositery {
    private EmployeeDoa bookDoa ;
    private LiveData<List<Employee>> getAllEmployees;
    private List<Employee> getAllEmployeesArray;

    public EmployeesRepositery(Application application) {
        TasksRoomDatabase bookRoomDb = TasksRoomDatabase.getInstance(application);
        bookDoa=bookRoomDb.employeeDoa();
        getAllEmployees=bookDoa.getAllEmployees();
        getAllEmployeesArray=bookDoa.getAllEmployeesList();
    }
    //getallEmployees
    public LiveData<List<Employee>> getGetAllEmployees(){
        return getAllEmployees;

    }
    public  List<Employee> getGetAllEmployeesArray(){
        return getAllEmployeesArray;

    }



}
