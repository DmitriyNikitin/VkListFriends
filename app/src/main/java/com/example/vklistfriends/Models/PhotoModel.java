package com.example.vklistfriends.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by админ on 02.10.2017.
 */

public class PhotoModel {
    @SerializedName("pid")
    @Expose
    public Integer pid;
    @SerializedName("aid")
    @Expose
    public Integer aid;
    @SerializedName("owner_id")
    @Expose
    public Integer ownerId;
    @SerializedName("src")
    @Expose
    public String src;
    @SerializedName("src_big")
    @Expose
    public String srcBig;
    @SerializedName("src_small")
    @Expose
    public String srcSmall;
    @SerializedName("src_xbig")
    @Expose
    public String srcXbig;
    @SerializedName("src_xxbig")
    @Expose
    public String srcXxbig;
    @SerializedName("width")
    @Expose
    public Integer width;
    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("text")
    @Expose
    public String text;
    @SerializedName("created")
    @Expose
    public Integer created;

    @SerializedName("sizes")
    @Expose
    public ArrayList<SizeModel> sizes;
}
