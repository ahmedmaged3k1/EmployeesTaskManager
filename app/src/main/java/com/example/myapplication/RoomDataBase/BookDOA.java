package com.example.myapplication.RoomDataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDOA {
    @Insert
    public void TasksInsert(Tasks tasks);

    @Update
    public void TasksUpdate(Tasks tasks);

    @Delete
    public void TasksDelete(Tasks tasks);

    @Query("select * from tasks")
    public LiveData<List<Tasks>>  getAllTasks();

}