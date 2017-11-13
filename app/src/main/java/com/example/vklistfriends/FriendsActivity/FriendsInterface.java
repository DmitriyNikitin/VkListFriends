package com.example.vklistfriends.FriendsActivity;

import com.example.vklistfriends.Models.ResponseModel;

import java.util.ArrayList;

/**
 * Created by админ on 01.10.2017.
 */

public interface FriendsInterface {
    void basaStore (ArrayList<ResponseModel> arrayList);
    void onSuccess(ArrayList<ResponseModel> arrayList);
    void onFailed();
}
