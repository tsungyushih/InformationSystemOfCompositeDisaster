package com.frandog.informationsystemofcompositedisaster;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Spinner;

public class Main5Activity extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        setTitle("停班停課資訊");
        wv=findViewById(R.id.webview);
        wv.setWebViewClient(new WebViewClient(){
//            当 load 通过 ssl 加密的 https 页面，且这个网站的安全证书在 Android 无法得到认证时，WebView就会变成一个空白页，而并不会像自带的浏览器一样弹出提示。因此，我们必须针对这种情况进行处理。
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();      //Ignore SSL certificate errors
//              super.onReceivedSslError(view, handler, error);   //不要調用
            }
        });

        wv.getSettings().setJavaScriptEnabled(true);    //JavaScript內建式關閉的，要打開，否則無法開Youtube
        wv.loadUrl("https://www.dgpa.gov.tw/typh/daily/nds.html?uid=31");



    }
}
