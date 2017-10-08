package com.example.vklistfriends;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.vklistfriends.Managers.APIManager;
import com.example.vklistfriends.Managers.AuthManager;
import com.example.vklistfriends.Managers.FriendsManager;

import java.util.ArrayList;
import java.util.StringTokenizer;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by админ on 01.10.2017.
 */

public class CustomWebViewClient extends WebViewClient {

    private String response;
    private String access_token;
    private String accessToken;
    private MainActivity activity;

    public CustomWebViewClient(MainActivity act) {
        activity = act;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);

        Uri inquiry = Uri.parse(url);
        response = inquiry.getFragment();

        if (response != null) {
            StringTokenizer access = new StringTokenizer(response, "&");

            access_token = access.nextToken();
            StringTokenizer aT = new StringTokenizer(access_token, "=");
             aT.nextToken();
            accessToken = aT.nextToken();

            //// TODO: 08.09.2017 создать authmanager
            AuthManager authManager = new AuthManager(activity);
            //сохранить токен в authManadger
            authManager.saveToken(accessToken);

            Intent intent = new Intent(activity, FriendListActivity.class);
            activity.startActivity(intent);

            return true;
        }

        return true;
    }
}
