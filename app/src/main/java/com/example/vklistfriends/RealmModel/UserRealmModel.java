package com.example.vklistfriends.RealmModel;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by админ on 13.10.2017.
 */

public class UserRealmModel extends RealmObject {


    private String accessToken;


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String acessToken) {

        this.accessToken = acessToken;
    }
}
