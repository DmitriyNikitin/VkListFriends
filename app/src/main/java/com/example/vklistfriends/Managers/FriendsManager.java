package com.example.vklistfriends.Managers;

import com.example.vklistfriends.FriendsActivity.FriendsInterface;
import com.example.vklistfriends.PhotoFriends.PhotoInterface;
import com.example.vklistfriends.Models.PhotoModel;
import com.example.vklistfriends.PhotoFriends.ResponsePhoto;
import com.example.vklistfriends.FriendsActivity.ResponseFriend;
import com.example.vklistfriends.Models.ResponseModel;

import java.util.ArrayList;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by админ on 01.10.2017.
 */

public class FriendsManager {
    private  String accessToken;
    public final String
            fields = "photo_100",
            order = "name";


    private ArrayList<ResponseModel> arrayInfoFriends;
    private ArrayList<PhotoModel> arrayInfoPhoto;

    public  FriendsManager(String token){
        this.accessToken = token;
    }
    public  FriendsManager(){}



    public void fetch(final FriendsInterface friendsInterface){


        APIManager.getInstance().getRequestInterface().getCall( accessToken, fields, order).enqueue(new Callback<ResponseFriend>() {
            @Override
            public void onResponse(Call<ResponseFriend> call, Response<ResponseFriend> response) {

                ResponseFriend friend = response.body();
                arrayInfoFriends = friend.getFriends();
                RealmManager rM = new RealmManager();
                rM.saveFriends(arrayInfoFriends);
                friendsInterface.ifSuccess(arrayInfoFriends);
            }

            @Override
            public void onFailure(Call<ResponseFriend> call, Throwable t) {
                friendsInterface.ifFailed();
}
        });
                }


    public void getPhotoFriend(Integer ownerId, String albumId, Integer rev, Integer photoSizes, final PhotoInterface photoInterface){

        APIManager.getInstance().getRequestInterface().getPhoto(ownerId, albumId, rev, photoSizes).enqueue(new Callback<ResponsePhoto>() {
            @Override
            public void onResponse(Call<ResponsePhoto> call, Response<ResponsePhoto> response) {
                ResponsePhoto foto = response.body();
                arrayInfoPhoto = foto.getPhoto();
                photoInterface.ifSuccess(arrayInfoPhoto);
            }

            @Override
            public void onFailure(Call<ResponsePhoto> call, Throwable t) {
                photoInterface.ifFailed();
            }
        });

    }

}
