package com.example.myapplication.RoomDataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TasksViewModel extends AndroidViewModel {
    private TasksRepositery tasksRepositery;
    private LiveData<List<Tasks>> allTasks ;
    public TasksViewModel(@NonNull @org.jetbrains.annotations.NotNull Application application) {
        super(application);
        tasksRepositery = new TasksRepositery(application);
        allTasks=tasksRepositery.getGetAllTasks();
    }
    public void insert(Tasks tasks){
        tasksRepositery.insert(tasks);

    }
    public void delete(Tasks tasks){
        tasksRepositery.delete(tasks);

    }
    public void update(Tasks tasks){
        tasksRepositery.update(tasks);

    }
    public LiveData<List<Tasks>> getAllTasks(){
        return  tasksRepositery.getGetAllTasks();

    }

}
