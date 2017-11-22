package com.example.appfragments.Realm.RealmModel;

import io.realm.RealmObject;

/**
 * Created by админ on 21.11.2017.
 */

public class ContactModel extends RealmObject {
    private String firstName;
    private String lastName;
    private String telefon;

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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
