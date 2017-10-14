package com.example.vklistfriends.Managers;

/**
 * Created by админ on 01.10.2017.
 */

public class AuthManager {

    RealmManager realmManager;

    public AuthManager(){
        realmManager = new RealmManager();
    }

    public void saveToken(String accessToken){


        realmManager.saveUser(accessToken);

    }
    public String getToken(){


        return realmManager.getUser();
    }
}
