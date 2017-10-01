package com.example.vklistfriends;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


/**
 * Created by админ on 01.10.2017.
 */

public class ResponseFriend {

        @SerializedName("response")
        @Expose
        private ArrayList<ResponseModel> friends;


        public ArrayList<ResponseModel> getFriends(){
                return friends;
        }
}

