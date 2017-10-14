package com.example.vklistfriends.MainActivity;


import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.vklistfriends.FriendsActivity.FriendListActivity;
import com.example.vklistfriends.Managers.AuthManager;


import java.util.StringTokenizer;

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
            AuthManager authManager = new AuthManager();
            //сохранить токен в authManadger
            authManager.saveToken(accessToken);

            Intent intent = new Intent(activity, FriendListActivity.class);
            activity.startActivity(intent);

            return true;
        }

        return true;
    }
}
