package com.frandog.informationsystemofcompositedisaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    Spinner s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("地震資訊");
        s=findViewById(R.id.spinner);

        ArrayList<String> arraylist = new ArrayList<>();
        arraylist.add("顯著有感地震");
        arraylist.add("小區域有感地震");
        arraylist.add("海嘯資訊");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                Main2Activity.this,
                android.R.layout.simple_list_item_1,
                arraylist);

        s.setAdapter(adapter);
    }
}
