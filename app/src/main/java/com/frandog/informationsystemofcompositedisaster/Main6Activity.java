package com.frandog.informationsystemofcompositedisaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Main6Activity extends AppCompatActivity {
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        sp = findViewById(R.id.spinner4);
        setTitle("停水停電資訊");

        ArrayList<String> al = new ArrayList();
        al.add("停水資訊");
        al.add("停電資訊");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                Main6Activity.this,
                android.R.layout.simple_list_item_1,
                al
        );
        sp.setAdapter(adapter);
    }
}
