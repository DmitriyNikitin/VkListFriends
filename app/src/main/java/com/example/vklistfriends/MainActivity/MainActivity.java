package com.example.vklistfriends.MainActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;


import com.example.vklistfriends.FriendsActivity.FriendListActivity;
import com.example.vklistfriends.Managers.AuthManager;
import com.example.vklistfriends.R;

import io.realm.Realm;


public class MainActivity extends AppCompatActivity {

    WebView webView;
    String token;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);



        webView = (WebView) findViewById(R.id.web);

        AuthManager aM = new AuthManager();

        token = aM.getToken();

        if ( token != null) {
            Intent intent = new Intent(this, FriendListActivity.class);
            startActivity(intent);
        } else {
            WebWork webWork = new WebWork(this);
            webWork.startWork();
        }
    }

    @Override
    public void onDestroy() {

        super.onDestroy();


    }
}

