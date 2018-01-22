package com.frandog.informationsystemofcompositedisaster;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
    Spinner sp3;
    WebView wb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        sp3=findViewById(R.id.spinner3);
        setTitle("PM2.5與紫外線");
        ArrayList<String> al = new ArrayList();
        al.add("空氣品質指標");
        al.add("紫外線指數");
        al.add("紫外線即時預測");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main4Activity.this,
                android.R.layout.simple_list_item_1,
                al);

        sp3.setAdapter(adapter);

        wb = findViewById(R.id.webview2);
        wb.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
        wb.getSettings().setJavaScriptEnabled(true);
        wb.loadUrl("https://taqm.epa.gov.tw/taqm/aqi-map.aspx");
    }
}
