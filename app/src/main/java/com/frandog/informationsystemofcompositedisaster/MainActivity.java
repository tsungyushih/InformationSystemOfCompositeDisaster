package com.frandog.informationsystemofcompositedisaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] str = new String[]{"地震資訊","颱風資訊","PM2.5與紫外線","停班停課資訊","停水停電資訊"};
        ListView lv = findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                str);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent();

                switch (position) {
                    case 0:
                        it.setClass(MainActivity.this, Main2Activity.class);
                        startActivity(it);
                        break;
                    case 1:
                        it.setClass(MainActivity.this, Main3Activity.class);
                        startActivity(it);
                        break;
                    case 2:
                        it.setClass(MainActivity.this, Main4Activity.class);
                        startActivity(it);
                        break;
                    case 3:
                        it.setClass(MainActivity.this, Main5Activity.class);
                        startActivity(it);
                        break;
                    case 4:
                        it.setClass(MainActivity.this, Main6Activity.class);
                        startActivity(it);
                        break;
                }
            }
           });
    }
}