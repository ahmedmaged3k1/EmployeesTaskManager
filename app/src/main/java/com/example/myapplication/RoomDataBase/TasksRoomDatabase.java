package com.example.myapplication.RoomDataBase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Tasks.class,Employee.class} ,version = 1)
public  abstract  class TasksRoomDatabase extends RoomDatabase {

    private static TasksRoomDatabase tasksRoomDatabaseinstance ;
    public abstract BookDOA bookDOA() ;
    public abstract EmployeeDoa employeeDoa() ;
    ///Singlton Pattern
    public static synchronized TasksRoomDatabase getInstance(Context context){
        if(tasksRoomDatabaseinstance==null){
            tasksRoomDatabaseinstance= Room.databaseBuilder(context.getApplicationContext(),
                    TasksRoomDatabase.class,"BookDatabase").fallbackToDestructiveMigration().addCallback(roomCallBack).build();

        }
        return tasksRoomDatabaseinstance;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDataAsyncTask(tasksRoomDatabaseinstance).execute();
        }


        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };
    private static class PopulateDataAsyncTask extends AsyncTask<Void ,Void,Void> {
        private BookDOA bookDoa;
        private EmployeeDoa employeeDoa;

        public PopulateDataAsyncTask(TasksRoomDatabase bookRoamDb) {
            bookDoa=bookRoamDb.bookDOA();
            employeeDoa=bookRoamDb.employeeDoa();
        }


        @Override
        protected Void doInBackground(Void... voids) {
         bookDoa.TasksInsert(new Tasks(1,"WebPage Delivery ","four web pages you need to deliver with their implementation ","5/31/2021"
         ,"1/5/2021","Tarek",1));
            bookDoa.TasksInsert(new Tasks(1,"WebPage Delivery ","four web pages you need to deliver with their implementation ","5/31/2021"
                    ,"1/5/2021","Sara",2));
            bookDoa.TasksInsert(new Tasks(7,"WebPage Delivery ","four web pages you need to deliver with their implementation ","5/31/2021"
                    ,"1/5/2021","Ahmed",3));
            bookDoa.TasksInsert(new Tasks(1,"WebPage Delivery ","four web pages you need to deliver with their implementation ","5/31/2021"
                    ,"1/5/2021","Ziad",4));
            bookDoa.TasksInsert(new Tasks(1,"WebPage Delivery ","four web pages you need to deliver with their implementation ","5/31/2021"
                    ,"1/5/2021","Raghad",5));
            bookDoa.TasksInsert(new Tasks(1,"WebPage Delivery ","four web pages you need to deliver with their implementation ","5/31/2021"
                    ,"1/5/2021","Salah",6));
            bookDoa.TasksInsert(new Tasks(1,"Gui Discussion ","10 forms  you need to deliver with their implementation ","5/31/2021"
                    ,"1/5/2021","Tarek",1));
            bookDoa.TasksInsert(new Tasks(1,"Math Assigment","you must solve all required problems ","5/31/2021"
                    ,"1/5/2021","Ahmed",3));
            bookDoa.TasksInsert(new Tasks(4,"Gui Discussion ","10 forms  you need to deliver with their implementation ","5/31/2021"
                    ,"1/5/2021","Ahmed",3));
            employeeDoa.EmployeeInsert(new Employee("Tarek",1234,1));
            employeeDoa.EmployeeInsert(new Employee("Sara",1234,2));
            employeeDoa.EmployeeInsert(new Employee("Ahmed",1234,3));
            employeeDoa.EmployeeInsert(new Employee("Raghad",1234,5));
            employeeDoa.EmployeeInsert(new Employee("Salah",1234,6));
            employeeDoa.EmployeeInsert(new Employee("Ziad",1234,4));

            return null;
        }
    }
}
