package com.example.vklistfriends;

import java.util.ArrayList;

/**
 * Created by админ on 01.10.2017.
 */

public interface FriendsInterface {
    void ifSuccess(ArrayList<ResponseModel> arrayList);
    void ifFailed();
}
