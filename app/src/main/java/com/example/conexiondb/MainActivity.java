package com.example.conexiondb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.conexiondb.myDB;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView text;
    private myDB myyDB;
    private myDataBaseHelper database ;
    private Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text= findViewById(R.id.texto);
        spin = findViewById(R.id.spinner);

        crear();
        spin.setOnItemSelectedListener(this);
        Spinner spinner = findViewById(R.id.spinner);
        myyDB = new myDB(this);
        Cursor cur= myyDB.selectRecords();
        String[] from = new String[]{"name"};
        int[] to = new int[]{android.R.id.text1};
        SimpleCursorAdapter adapta = new SimpleCursorAdapter(this,android.R.layout.simple_spinner_dropdown_item,cur,from,to);
        ArrayAdapter<CharSequence> adapter;

        adapta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapta);
    }

    public void crear(){
        myDataBaseHelper my= new myDataBaseHelper(this);
        myyDB = new myDB(this);

        myyDB.createRecords("0","Home");
        myyDB.createRecords("1","Work");
        myyDB.createRecords("2","Mobile");
        myyDB.createRecords("3","Other");
        Cursor cur= myyDB.selectRecords();
        text.append(cur.getString(0)+"  "+cur.getString(1)+" \n");
        while(cur.moveToNext()){
            text.append(cur.getString(0)+"  "+cur.getString(1)+" \n");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
