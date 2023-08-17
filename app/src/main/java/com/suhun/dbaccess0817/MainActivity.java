package com.suhun.dbaccess0817;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private EditText whichIdUpdate, name, tel, birthday, whichIdDelete;

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

    }
}