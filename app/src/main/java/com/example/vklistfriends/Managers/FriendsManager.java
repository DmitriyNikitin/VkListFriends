package com.example.vklistfriends.Managers;

import android.content.Intent;
import android.content.SharedPreferences;

import com.example.vklistfriends.FriendsInterface;
import com.example.vklistfriends.PhotoFriends.PhotoInterface;
import com.example.vklistfriends.PhotoFriends.PhotoModel;
import com.example.vklistfriends.PhotoFriends.ResponsePhoto;
import com.example.vklistfriends.ResponseFriend;
import com.example.vklistfriends.ResponseModel;

import java.util.ArrayList;
import java.util.List;

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
                friendsInterface.ifSuccess(arrayInfoFriends);
            }

            @Override
            public void onFailure(Call<ResponseFriend> call, Throwable t) {
                friendsInterface.ifFailed();
}
        });
                }


    public void getPhotoFriend(Integer ownerId, String albumId, Integer rev, final PhotoInterface photoInterface){

        APIManager.getInstance().getRequestInterface().getPhoto(ownerId, albumId, rev).enqueue(new Callback<ResponsePhoto>() {
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
