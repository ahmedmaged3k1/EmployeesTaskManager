package com.example.myapplication.RoomDataBase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TasksRepositery {
    private BookDOA bookDoa ;
    private LiveData<List<Tasks>> getAllTasks;

    public TasksRepositery(Application application) {
        TasksRoomDatabase bookRoomDb = TasksRoomDatabase.getInstance(application);
        bookDoa=bookRoomDb.bookDOA();
        getAllTasks=bookDoa.getAllTasks();
    }

    //insert

    public void insert(Tasks tasks){
        new InsertAsyncClass(bookDoa).execute(tasks);
    }

    //delete

    public void delete(Tasks tasks){

        new DeleteAsyncClass(bookDoa).execute(tasks);
    }
    //update

    public void update(Tasks tasks){
        new UpdateAsyncClass(bookDoa).execute(tasks);
    }



    //getallbooks

    public LiveData<List<Tasks>> getGetAllTasks(){
        return getAllTasks;

    }
    private  static class  InsertAsyncClass extends AsyncTask<Tasks,Void,Void> {
        private BookDOA bookDoa ;

        public InsertAsyncClass(BookDOA bookDoa) {
            this.bookDoa = bookDoa;
        }

        @Override
        protected Void doInBackground(Tasks... tasks) {
            bookDoa.TasksInsert(tasks[0]);
            return null;
        }
    }
    private  static class  DeleteAsyncClass extends AsyncTask<Tasks,Void,Void> {
        private BookDOA bookDoa ;

        public DeleteAsyncClass(BookDOA bookDoa) {
            this.bookDoa = bookDoa;
        }

        @Override
        protected Void doInBackground(Tasks... tasks) {
            bookDoa.TasksDelete(tasks[0]);
            return null;
        }
    }
    private  static class UpdateAsyncClass extends AsyncTask<Tasks,Void,Void> {
        private BookDOA bookDoa ;

        public UpdateAsyncClass(BookDOA bookDoa) {
            this.bookDoa = bookDoa;
        }

        @Override
        protected Void doInBackground(Tasks... tasks) {
            bookDoa.TasksUpdate(tasks[0]);
            return null;
        }
    }


}
