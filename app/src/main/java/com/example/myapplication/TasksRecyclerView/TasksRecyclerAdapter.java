package com.example.myapplication.TasksRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.RoomDataBase.Tasks;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TasksRecyclerAdapter extends RecyclerView.Adapter<TasksRecyclerAdapter.TasksHolder> {
     private  Context context ;
     private List<Tasks> tasks=new ArrayList<>();

    public TasksRecyclerAdapter(Context context, List<Tasks> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    @NonNull
    @NotNull
    @Override
    public TasksHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tasks_recycle_view,parent,false);
        return new TasksHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TasksRecyclerAdapter.TasksHolder holder, int position) {
        holder.taskTitle.setText(tasks.get(position).getTaskTitle());
        holder.taskPriority.setText(String.valueOf(tasks.get(position).getPriority()));
        holder.taskEndDate.setText(tasks.get(position).getEndDate());
        holder.taskAssignDate.setText(tasks.get(position).getAssigningDate());
        holder.taskDescription.setText(tasks.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TasksHolder extends RecyclerView.ViewHolder {
        TextView taskTitle;
        TextView taskDescription ;
        TextView taskAssignDate;
        TextView taskEndDate;
        TextView taskPriority;
        public TasksHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            taskTitle=itemView.findViewById(R.id.TaskTitle);
            taskAssignDate=itemView.findViewById(R.id.TaskAssignDate);
            taskDescription=itemView.findViewById(R.id.TaskDescripton);
            taskEndDate=itemView.findViewById(R.id.TaskEndDate);
            taskPriority=itemView.findViewById(R.id.TaskPriority);
        }
    }
}
