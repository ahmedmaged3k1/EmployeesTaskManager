package com.example.myapplication.RoomDataBase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Employee {
    private String name;
    private int password;
    @PrimaryKey
    private int id;

    public Employee(String name, int password, int id) {
        this.name = name;
        this.password = password;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
