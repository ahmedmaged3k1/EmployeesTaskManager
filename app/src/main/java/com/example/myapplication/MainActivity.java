package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.TabStopSpan;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.RoomDataBase.Tasks;
import com.example.myapplication.RoomDataBase.TasksViewModel;
import com.example.myapplication.TasksRecyclerView.TasksRecyclerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private TextView textView;
    private TasksViewModel tasksViewModel;
    private RecyclerView tasksRecyclerView ;
    TextView loginText;
    private TasksRecyclerAdapter tasksRecyclerViewAdapter;
    private List<Tasks> tasks=new ArrayList<>();
    private List<Tasks> employeesTasks=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertTasks();
        getIncomingIntent();
        setBookRecycleView();

        //roomDBInitialize();


    }
    public void  getIncomingIntent(){
        loginText=findViewById(R.id.textView2);
        Intent intent = getIntent();
        int id =intent.getIntExtra("ID",1);
        for(int i=0;i<tasks.size();i++) {
            if (tasks.get(i).getEmployeeID() == id) {
                Log.d(TAG, "getIncomingIntent: "+tasks.get(i).getEmployeeName());
                loginText.setText(tasks.get(i).getEmployeeName() + " this is your tasks list");
                break;
            }
        }
        for(int i=0;i<tasks.size();i++){
            if(tasks.get(i).getEmployeeID()==id){
                employeesTasks.add(tasks.get(i));
            }
            Collections.sort(employeesTasks);
        }

        //Log.d(TAG, "getIncomingIntent: "+ id );
        //loginText.setText(tasks.get(id).getEmployeeName()+" this is your tasks list");
    }
    public void roomDBInitialize(){
        tasksViewModel=  ViewModelProviders.of(this).get(TasksViewModel.class);
        tasksViewModel.getAllTasks().observe(this, new Observer<List<Tasks>>() {
            @Override
            public void onChanged(List<Tasks> tasks) {
                //  textView.setText(tasks.get(0).getEmployeeName());
                tasksRecyclerViewAdapter.setTasks(tasks);

            }
        });
    }
    public void setBookRecycleView(){
        tasksRecyclerView=findViewById(R.id.TasksrecyclerView);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasksRecyclerView.setHasFixedSize(true);
        tasksRecyclerViewAdapter= new TasksRecyclerAdapter(this,employeesTasks);
        tasksRecyclerView.setAdapter(tasksRecyclerViewAdapter);
        ItemTouchHelper.SimpleCallback itemTouchHelperCallBack = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull @NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder, @NonNull @NotNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int direction) {
                int index = viewHolder.getAdapterPosition();
                employeesTasks.remove(index);
                tasksRecyclerViewAdapter.notifyDataSetChanged();
                if(employeesTasks.size()!=0)
                Toast.makeText(getBaseContext()," Your Next Task is :  "+employeesTasks.get(index).getTaskTitle(),Toast.LENGTH_SHORT).show();
                else if(employeesTasks.size()==0)
                    Toast.makeText(getBaseContext()," Congrats All Tasks Are Done Keep Up The Good Work ",Toast.LENGTH_SHORT).show();
                else if(employeesTasks.size()-1==index)
                    Log.d(TAG, "onSwiped: ");
            }
        };
        new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(tasksRecyclerView);
    }



    public void insertTasks(){
        tasks.add(new Tasks(3,"WebPage Delivery ","four web pages you need to deliver with their implementation ","5/31/2021"
                ,"1/5/2021","Tarek",1));
        tasks.add(new Tasks(1,"WebPage Delivery ","four web pages you need to deliver with their implementation ","5/31/2021"
                ,"1/5/2021","Sara",2));
        tasks.add(new Tasks(8,"WebPage Delivery ","four web pages you need to deliver with their implementation ","5/31/2021"
                ,"1/5/2021","Ahmed",3));
        tasks.add(new Tasks(1,"WebPage Delivery ","four web pages you need to deliver with their implementation ","5/31/2021"
                ,"1/5/2021","Ziad",4));
        tasks.add(new Tasks(2,"WebPage Delivery ","four web pages you need to deliver with their implementation ","5/31/2021"
                ,"1/5/2021","Raghad",5));
        tasks.add(new Tasks(1,"WebPage Delivery ","four web pages you need to deliver with their implementation ","5/31/2021"
                ,"1/5/2021","Salah",6));
        tasks.add(new Tasks(1,"Gui Discussion ","10 forms  you need to deliver with their implementation ","5/31/2021"
                ,"1/5/2021","Tarek",1));
        tasks.add(new Tasks(3,"Math Assigment","you must solve all required problems ","5/31/2021"
                ,"1/5/2021","Ahmed",3));
        tasks.add(new Tasks(7,"Gui Discussion ","10 forms  you need to deliver with their implementation ","5/31/2021"
                ,"1/5/2021","Ahmed",3));
        tasks.add(new Tasks(7,"Algorithm Final ","8 Lectures with 8 Labs you must study  ","12/6/2021"
                ,"13/6/2021","Eman Pepars",7));
        tasks.add(new Tasks(6,"Modelling and Simulation Final ","8 Lectures with 8 Labs you must study  ","13/6/2021"
                ,"15/6/2021","Eman Pepars",7));
        tasks.add(new Tasks(2,"Deyoong Task ","8 Lectures with 8 Labs you must study  ","13/6/2021"
                ,"15/6/2021","Eman Pepars",7));

        Collections.sort(tasks);
    }

}