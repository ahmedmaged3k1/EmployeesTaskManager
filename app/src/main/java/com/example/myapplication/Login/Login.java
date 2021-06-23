package com.example.myapplication.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.RoomDataBase.Employee;
import com.example.myapplication.RoomDataBase.EmployeeViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    EditText userId ;
    EditText userPassword;
    AppCompatButton loginButton;
    ArrayList<Employee> employees=new ArrayList<Employee>();
    EmployeeViewModel employeeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userId=findViewById(R.id.loginId);
        userPassword=findViewById(R.id.loginPassword);
        loginButton=findViewById(R.id.loginButton);
        //employees= (ArrayList<Employee>) employeeViewModel.getGetAllEmployeesArray();
        insertEmployees();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idd =userId.getText().toString();
                String pass=userPassword.getText().toString();
                int id = Integer.parseInt(idd);
                int password = Integer.parseInt(pass);
                if(id>employees.size()){
                    Toast.makeText(Login.this, "Enter Valid ID", Toast.LENGTH_SHORT).show();
                }
                   else if(employees.get(id-1).getId()==id){
                        if(employees.get(id-1).getPassword()==password){
                            Intent mainpage = new Intent(getApplicationContext(),MainActivity.class);
                            mainpage.putExtra("ID",employees.get(id-1).getId());
                            mainpage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            getApplicationContext().startActivity(mainpage);

                        }
                        else{
                            Toast.makeText(Login.this, "Enter Valid Password", Toast.LENGTH_SHORT).show();
                        }
                    }



                }

        });

    }
    void insertEmployees(){
        employees.add(new Employee("Tarek",1234,1));
        employees.add(new Employee("Sara",1234,2));
        employees.add(new Employee("Ahmed",1234,3));
        employees.add(new Employee("Ziad",1234,4));
        employees.add(new Employee("Raghad",1234,5));
        employees.add(new Employee("Salah",1234,6));

        employees.add(new Employee("Tarek",1234,7));
    }
}