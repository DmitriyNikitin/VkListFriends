package com.example.vklistfriends.PhotoFriends;

import com.example.vklistfriends.Models.PhotoModel;

import java.util.ArrayList;

/**
 * Created by админ on 08.10.2017.
 */

public interface PhotoInterface {
    void onSuccess(ArrayList<PhotoModel> arrayList);
    void onFailed();
}
