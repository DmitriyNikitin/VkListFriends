package com.example.vklistfriends.MainActivity;

/**
 * Created by админ on 01.10.2017.
 */

public class WebWork {

    private MainActivity acticity;

    private final String host_authorize = "https://oauth.vk.com/authorize",
            client_id = "client_id=6043385",
            display = "display=mobile",
            redirect_uri = "redirect_uri=https://oauth.vk.com/blank.html",
            scope = "scope=friends,offline",
            response_type = "response_type=token",
            version = "v=5.68",
            revoke = "revoke=0";
    private String authorize = host_authorize + "?" + client_id + "&" + display + "&" + redirect_uri + "&" + scope + "&" + response_type + "&" + version + "&" + revoke;

    public WebWork(MainActivity acticity){

        this.acticity = acticity;

    }

    public void startWork(){

        acticity.webView.setWebViewClient(new CustomWebViewClient(acticity));
        acticity.webView.loadUrl(authorize);


    }

}

