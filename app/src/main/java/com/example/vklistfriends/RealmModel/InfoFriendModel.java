package com.example.vklistfriends.RealmModel;

import io.realm.RealmObject;

/**
 * Created by админ on 13.10.2017.
 */

public class InfoFriendModel extends RealmObject {
    private String firstName;
    private String lastName;
    private Integer uid;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
