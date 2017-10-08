package com.example.vklistfriends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;


import com.example.vklistfriends.Managers.AuthManager;


public class MainActivity extends AppCompatActivity {

    WebView webView;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.web);

        AuthManager aM = new AuthManager(this);

        token = aM.getToken();

        if (token != null) {
            Intent intent = new Intent(this, FriendListActivity.class);
            startActivity(intent);
        } else {
            WebWork webWork = new WebWork(this);
            webWork.startWork();
        }
    }
}
