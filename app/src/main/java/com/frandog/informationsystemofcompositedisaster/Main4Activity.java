package com.frandog.informationsystemofcompositedisaster;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.frandog.informationsystemofcompositedisaster.Fragment.BlankFragment;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main4Activity extends AppCompatActivity {
    Spinner sp3;
    Main4_MyAdapter adapter;
    Main4_MyHandler dataHandler;

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

        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 1:
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.layout2,new BlankFragment());
                        ft.commit();

                    //抓網站資料
                    String str_url = "http://opendata2.epa.gov.tw/AQI.xml";
                    URL url = null;
                        try {
                            url = new URL(str_url);
                            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                            conn.setRequestMethod("GET");
                            conn.connect();
                            InputStream inputStream = conn.getInputStream();
                            InputStreamReader isr = new InputStreamReader(inputStream);
                            BufferedReader br = new BufferedReader(isr);
                            StringBuilder sb = new StringBuilder();
                            String str;
                            while ((str = br.readLine()) != null)
                            {
                                sb.append(str);
                            }
                            String str1 = sb.toString();
                            dataHandler = new Main4_MyHandler();
                            SAXParserFactory spf = SAXParserFactory.newInstance();      //本三行為固定寫法
                            SAXParser sp = spf.newSAXParser();
                            XMLReader xr = sp.getXMLReader();
                            xr.setContentHandler(dataHandler);
                            xr.parse(new InputSource(new StringReader(str1)));

                            br.close();
                            isr.close();
                            inputStream.close();

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run(){
//                                    adapter = new MyAdapter(MainActivity.this,
//                                            dataHandler.newsItems);
//                                    lv.setAdapter(adapter);
                                }
                            });
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (ParserConfigurationException e) {
                            e.printStackTrace();
                        } catch (SAXException e) {
                            e.printStackTrace();
                        } catch (ProtocolException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
