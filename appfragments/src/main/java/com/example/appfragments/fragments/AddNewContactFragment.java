package com.example.appfragments.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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

    String firstNameStr;
    String lastNameStr;
    String phoneStr;

    public AddNewContactFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       if(savedInstanceState != null){
            this.firstNameStr = savedInstanceState.getString("firstName");
            this.lastNameStr = savedInstanceState.getString("lastName");
            this.phoneStr = savedInstanceState.getString("phone");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fargment_add_new_contact, container, false);
        Bundle bundle = new Bundle();

        firstName = (EditText)view.findViewById(R.id.firstName);
        lastName = (EditText)view.findViewById(R.id.lastName);
        telefon = (EditText)view.findViewById(R.id.telefon);
        createContact = (Button)view.findViewById(R.id.createBtn);

        firstName.setText(bundle.getString("firstName"));
        lastName.setText(bundle.getString("lastName"));
        telefon.setText(bundle.getString("phone"));
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
    
     public static AddNewContactFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AddNewContactFragment fragment = new AddNewContactFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("firstName", lastName.getText().toString());
        outState.putString("lastName", lastName.getText().toString());
        outState.putString("phone", telefon.getText().toString());
    }
}
