package com.frandog.informationsystemofcompositedisaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    Spinner s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        setTitle("颱風資訊");
        s2=findViewById(R.id.spinner2);

        ArrayList<String> al = new ArrayList<>();
        al.add("颱風消息與警報");
        al.add("雨量預測");
        al.add("風力預測");
        al.add("停班停課");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                Main3Activity.this,
                android.R.layout.simple_list_item_1,
                al);
        s2.setAdapter(adapter);

    }
}
