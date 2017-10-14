package com.example.vklistfriends.Managers;

import android.util.Log;

import com.example.vklistfriends.Models.ResponseModel;
import com.example.vklistfriends.RealmModel.InfoFriendModel;
import com.example.vklistfriends.RealmModel.UserRealmModel;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by админ on 13.10.2017.
 */

public class RealmManager  {

    UserRealmModel user;
    InfoFriendModel friend;
    Realm realm;
    public void saveUser(String accessToken){
        realm = Realm.getDefaultInstance();
        //создаю юзера и сохраняю

        realm.beginTransaction();

        user = realm.createObject(UserRealmModel.class);
        user.setAccessToken(accessToken);
        Log.d("","");
        realm.commitTransaction();
    }

        //делаю метод getUser который умеет получать UserRealm
        public String getUser () {
            realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            RealmResults<UserRealmModel> realmModels = realm.where(UserRealmModel.class).findAll();
            UserRealmModel userRealmModel = realmModels.get(realmModels.size() - 1);
           // realmModels.deleteAllFromRealm();
            String returnToken = userRealmModel.getAccessToken();
            realm.commitTransaction();

            return returnToken;
        }


        public void saveFriends(ArrayList<ResponseModel> friends) {


            for (Integer i = 0; i < friends.size(); i++) {


                realm = Realm.getDefaultInstance();


                realm.beginTransaction();

                friend = realm.createObject(InfoFriendModel.class);
                friend.setFirstName(friends.get(i).firstName);
                friend.setLastName(friends.get(i).lastName);
                friend.setUid(friends.get(i).uid);
                Log.d("", "");
                realm.commitTransaction();
            }
        }

    }

