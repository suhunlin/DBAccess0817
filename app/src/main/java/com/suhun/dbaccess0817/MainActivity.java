package com.suhun.dbaccess0817;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String tag = MainActivity.class.getSimpleName();
    private TextView result, birthday;
    private EditText whichIdUpdate, name, tel, whichIdDelete;
    private MyDBOpenHelper myDBOpenHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDateBase();
    }

    private void initView(){
        result = findViewById(R.id.lid_result);
        whichIdUpdate = findViewById(R.id.lid_updateIdInput);
        name = findViewById(R.id.lid_nameInput);
        tel = findViewById(R.id.lid_telInput);
        whichIdDelete = findViewById(R.id.lid_deleteIdInput);
        birthday = findViewById(R.id.lid_birthdayInput);
    }

    private void initDateBase(){
        myDBOpenHelper = new MyDBOpenHelper(this, "suhunDb", null, 1);
        db = myDBOpenHelper.getWritableDatabase();
    }

    public void queryFun(View view){
        execQuery();
    }

    private void execQuery(){
        StringBuffer stringBuffer = new StringBuffer();
        Cursor cursor = db.query("cust", null, null, null, null, null, null);
        while(cursor.moveToNext()){
            String id = cursor.getString(cursor.getColumnIndexOrThrow("cid"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("cname"));
            String tel = cursor.getString(cursor.getColumnIndexOrThrow("ctel"));
            String birthday = cursor.getString(cursor.getColumnIndexOrThrow("cbirthday"));
            String resultString = String.format("%s:%s:%s:%s\n", id, name, tel, birthday);
            stringBuffer.append(resultString);
        }
        result.setText(stringBuffer);
    }

    public void insertFun(View view){
        ContentValues values = new ContentValues();
        values.put("cname", name.getText().toString());
        values.put("ctel", tel.getText().toString());
        values.put("cbirthday", birthday.getText().toString());
        db.insert("cust", null, values);
        name.setText("");
        tel.setText("");
        birthday.setText("");
        execQuery();
    }

    public void updateFun(View view){
        ContentValues values = new ContentValues();
        String updateId = whichIdUpdate.getText().toString();
        String updateName = name.getText().toString();
        String updateTel = tel.getText().toString();
        String updateBirthday = birthday.getText().toString();
        if(updateId.equals("") || updateId.equals("Null")){
            Log.d(tag, "-----Not input id,do nothing----");
        }else{
            //name
            if(updateName.equals("") || updateName.equals("Null")){
                Log.d(tag, "-----Not input name,do nothing----");
            }else{
                values.put("cname", updateName);
            }
            //tel
            if(updateTel.equals("") || updateTel.equals("Null")){
                Log.d(tag, "-----Not input tel,do nothing----");
            }else{
                values.put("ctel", updateTel);
            }
            //birthday
            if(updateBirthday.equals("Touch to select birthday")||updateBirthday.equals("")){
                Log.d(tag, "-----Not input bir,do nothing----");
            }else{
                values.put("cbirthday", updateBirthday);
            }
            db.update("cust", values, "cid = ?",
                    new String[]{updateId});
            execQuery();
        }
    }

    public void deleteFun(View view){
        db.delete("cust", "cid = ?", new String[]{whichIdDelete.getText().toString()});
        execQuery();
        whichIdDelete.setText("");

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