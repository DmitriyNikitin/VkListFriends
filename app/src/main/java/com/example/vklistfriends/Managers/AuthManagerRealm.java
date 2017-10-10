package com.example.vklistfriends.Managers;

import io.realm.RealmObject;

/**
 * Created by админ on 10.10.2017.
 */

public class AuthManagerRealm extends RealmObject {
    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
