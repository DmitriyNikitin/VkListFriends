package com.example.appfragments.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appfragments.R;
import com.example.appfragments.Realm.RealmManager;

/**
 * Created by админ on 21.11.2017.
 */

public class AddNewContactFragment extends Fragment {


    EditText firstName;
    EditText lastName;
    EditText telefon;
    Button createContact;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fargment_add_new_contact, null);

        firstName = (EditText)view.findViewById(R.id.firstName);
        lastName = (EditText)view.findViewById(R.id.lastName);
        telefon = (EditText)view.findViewById(R.id.telefon);
        createContact = (Button)view.findViewById(R.id.createBtn);

        View.OnClickListener createContactListener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                RealmManager realmManager = new RealmManager();


                realmManager.saveContact(firstName.getText().toString(),lastName.getText().toString(), telefon.getText().toString());
                Toast.makeText(getContext(), "Контакт сохранен", Toast.LENGTH_SHORT).show();
            }
        };

        createContact.setOnClickListener(createContactListener);

        return view;
    }
}
