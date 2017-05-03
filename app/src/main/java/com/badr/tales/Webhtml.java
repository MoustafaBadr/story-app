package com.badr.tales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Webhtml extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webhtml);
        WebView web=(WebView)findViewById(R.id.webView);

        Intent data=getIntent();
        int page=data.getExtras().getInt("page");
        page++;
        web.loadUrl("file:///android_asset/"+page+".html");

    }
}
