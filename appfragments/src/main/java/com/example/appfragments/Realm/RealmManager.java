package com.example.appfragments.Realm;

import android.util.Log;
import android.widget.Toast;

import com.example.appfragments.Realm.RealmModel.ContactModel;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by админ on 21.11.2017.
 */

public class RealmManager {

    private ContactModel contactModel;
    private Realm realm;


    public void saveContact(String firstName, String lastName, String telefon) {
        realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        contactModel = realm.createObject(ContactModel.class);
        contactModel.setFirstName(firstName);
        contactModel.setLastName(lastName);
        contactModel.setTelefon(telefon);
        Log.d("", "");
        realm.commitTransaction();

    }

    public ArrayList<ContactModel> getContact() {
        ArrayList<ContactModel> allContacts = new ArrayList<ContactModel>();
        realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        RealmResults<ContactModel> realmModels = realm.where(ContactModel.class).findAll();
        if (realmModels.size() != 0) {
            for (Integer i = 0; i < realmModels.size(); i++) {
                // realmModels.deleteAllFromRealm();
                contactModel = realmModels.get(i);
                contactModel.getFirstName();
                contactModel.getLastName();
                contactModel.getTelefon();

                allContacts.add(i, contactModel);

            }

        }
        realm.commitTransaction();
        return allContacts;
    }
}
