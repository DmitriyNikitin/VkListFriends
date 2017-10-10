package com.example.vklistfriends.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by админ on 08.10.2017.
 */

public class SizeModel {
    @SerializedName("src")
    @Expose
    public String src;
    @SerializedName("width")
    @Expose
    public Integer width;
    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("type")
    @Expose
    public String type;

}
