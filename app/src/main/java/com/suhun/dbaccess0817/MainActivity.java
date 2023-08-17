package com.suhun.dbaccess0817;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView result, birthday;
    private EditText whichIdUpdate, name, tel, whichIdDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        result = findViewById(R.id.lid_result);
        whichIdUpdate = findViewById(R.id.lid_updateIdInput);
        name = findViewById(R.id.lid_nameInput);
        tel = findViewById(R.id.lid_telInput);
        whichIdDelete = findViewById(R.id.lid_deleteIdInput);
        birthday = findViewById(R.id.lid_birthdayInput);
    }

    public void queryFun(View view){

    }

    public void insertFun(View view){

    }

    public void updateFun(View view){

    }

    public void deleteFun(View view){

    }

    public void dateSelectFun(View view){
        DatePickerDialog dialog = new DatePickerDialog(this, DatePickerDialog.BUTTON_NEGATIVE, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String userSelect = String.format("%d-%d-%d", year, month+1, dayOfMonth);
                birthday.setText(userSelect);
            }
        }, 1977, 00, 01);
        dialog.show();
    }
}