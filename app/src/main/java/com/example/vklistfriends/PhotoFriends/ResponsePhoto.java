package com.example.vklistfriends.PhotoFriends;

import com.example.vklistfriends.ResponseModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;



/**
 * Created by админ on 02.10.2017.
 */

public class ResponsePhoto {


    @SerializedName("response")
    @Expose
    private ArrayList<PhotoModel> photo;

    public ArrayList<PhotoModel> getPhoto(){return photo;}
}
