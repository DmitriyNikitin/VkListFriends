package com.example.vklistfriends;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by админ on 01.10.2017.
 */

public interface RequestInterface {

    @FormUrlEncoded
    @POST("/method/friends.get")
    Call<ResponseFriend> getCall(
            @Field("access_token")String token,
            @Field("fields")String fields,
            @Field("order")String order
           );


}
