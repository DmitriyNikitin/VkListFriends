package com.example.vklistfriends;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    WebView webView;
    ListView listView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.web);
        listView = (ListView)findViewById(R.id.list);
        WebWork webWork = new WebWork(this);
        webWork.startWork();


    }
}
