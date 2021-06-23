package com.example.myapplication.RoomDataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class EmployeeViewModel  extends AndroidViewModel {
    private EmployeesRepositery employeesRepositery;
    private LiveData<List<Employee>> allEmployees ;
    private List<Employee> allEmployeesArray ;
    public EmployeeViewModel(@NonNull @org.jetbrains.annotations.NotNull Application application) {
        super(application);
        employeesRepositery = new EmployeesRepositery(application);
        allEmployees=employeesRepositery.getGetAllEmployees();
        allEmployeesArray=employeesRepositery.getGetAllEmployeesArray();
    }
    public LiveData<List<Employee>> getAllEmployees(){
        return  allEmployees;

    }
    public List<Employee> getGetAllEmployeesArray(){
        return  allEmployeesArray;
    }
}
