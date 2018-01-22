package com.frandog.informationsystemofcompositedisaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Main2Activity extends AppCompatActivity {
    Spinner s;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("地震資訊");
        s = findViewById(R.id.spinner);

        ArrayList<String> arraylist = new ArrayList<>();
        arraylist.add("顯著有感地震");
        arraylist.add("小區域有感地震");
        arraylist.add("海嘯資訊");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                Main2Activity.this,
                android.R.layout.simple_list_item_1,
                arraylist);

        s.setAdapter(adapter);
        tv = findViewById(R.id.textView);

    }


}



