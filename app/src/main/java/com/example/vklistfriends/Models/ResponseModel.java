package com.example.vklistfriends.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by админ on 01.10.2017.
 */

public class ResponseModel {

    @SerializedName("uid")
    @Expose
    public Integer uid;
    @SerializedName("first_name")
    @Expose
    public String firstName;
    @SerializedName("last_name")
    @Expose
    public String lastName;
    @SerializedName("photo_100")
    @Expose
    public String photo100;
    @SerializedName("online")
    @Expose
    public Integer online;

    }

