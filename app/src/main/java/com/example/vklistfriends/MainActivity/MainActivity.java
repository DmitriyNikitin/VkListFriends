package com.example.vklistfriends.MainActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;


import com.example.vklistfriends.FriendsActivity.FriendListActivity;
import com.example.vklistfriends.Managers.AuthManager;
import com.example.vklistfriends.Managers.AuthManagerRealm;
import com.example.vklistfriends.R;

import io.realm.Realm;


public class MainActivity extends AppCompatActivity {

    WebView webView;
    String token;
    Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.getInstance(this);
        mRealm = Realm.getInstance(MainActivity.this);

        AuthManagerRealm aMR = mRealm.createObject(AuthManagerRealm.class);


        webView = (WebView) findViewById(R.id.web);

        AuthManager aM = new AuthManager(this);

        token = aMR.getToken();

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

        mRealm.close();

    }
}

