package com.example.myapplication.RoomDataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface EmployeeDoa {
    @Insert
    public void EmployeeInsert(Employee employee);

    @Query("select * from Employee")
    public LiveData<List<Employee>> getAllEmployees();
    @Query("select * from Employee")
    public List<Employee> getAllEmployeesList();
}
