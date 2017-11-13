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
       if(accessToken == null)
       {
           throw new IllegalStateException("токен не может быть пустым") ;
       }

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
            if(realmModels.size() != 0){
            UserRealmModel userRealmModel = realmModels.get(realmModels.size() - 1);
           // realmModels.deleteAllFromRealm();
            String returnToken = userRealmModel.getAccessToken();
            realm.commitTransaction();

            return returnToken;
            }
            realm.commitTransaction();
            return null;
        }


        public void saveFriends(ArrayList<ResponseModel> friends) {

            realm = Realm.getDefaultInstance();

            for (Integer i = 0; i < friends.size(); i++) {

                realm.beginTransaction();

                friend = realm.createObject(InfoFriendModel.class);
                friend.setFirstName(friends.get(i).firstName);
                friend.setLastName(friends.get(i).lastName);
                friend.setUid(friends.get(i).uid);
                Log.d("", "");
                realm.commitTransaction();
            }
        }

        public ArrayList<ResponseModel> getFriends() {
            ArrayList<ResponseModel> infoFriends = new ArrayList<ResponseModel>();
            realm = Realm.getDefaultInstance();


            realm.beginTransaction();
            RealmResults<InfoFriendModel> realmModels = realm.where(InfoFriendModel.class).findAll();
            if (realmModels.size() != 0) {
                for(Integer i = 0; i < realmModels.size(); i++) {
                    InfoFriendModel infoFriendModel = realmModels.get(i);
                    // realmModels.deleteAllFromRealm();
                    ResponseModel responseModel = new ResponseModel();
                    responseModel.firstName = infoFriendModel.getFirstName();
                    responseModel.lastName = infoFriendModel.getLastName();
                    responseModel.uid = infoFriendModel.getUid();

                    infoFriends.add(i , responseModel);


                }
                realm.commitTransaction();
                return infoFriends;
            }
            realm.commitTransaction();
            return infoFriends;
        }

        public void deleteBaseFriends(){
            realm.beginTransaction();
            RealmResults<InfoFriendModel> realmModels = realm.where(InfoFriendModel.class).findAll();
            realmModels.deleteAllFromRealm();
            realm.commitTransaction();
        }
    }

