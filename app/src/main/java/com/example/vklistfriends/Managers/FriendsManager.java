package com.example.vklistfriends.Managers;

import com.example.vklistfriends.FriendsInterface;
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


    public  FriendsManager(String token){
        this.accessToken = token;
    }



    public void fetch(final FriendsInterface friendsInterface){


        APIManager.getInstance().getRequestInterface().getCall( accessToken, fields, order).enqueue(new Callback<ResponseFriend>() {
            @Override
            public void onResponse(Call<ResponseFriend> call, Response<ResponseFriend> response) {

                ResponseFriend friend = response.body();
                ArrayList<ResponseModel> arrayList = friend.getFriends();
                friendsInterface.ifSuccess(arrayList);
            }

            @Override
            public void onFailure(Call<ResponseFriend> call, Throwable t) {
                friendsInterface.ifFailed();
            }
        });
    }
}
