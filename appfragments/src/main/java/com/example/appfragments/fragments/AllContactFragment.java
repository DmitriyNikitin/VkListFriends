package com.example.appfragments.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.appfragments.Adapter.AllContactAdapter;
import com.example.appfragments.R;
import com.example.appfragments.Realm.RealmManager;

/**
 * Created by админ on 21.11.2017.
 */

public class AllContactFragment extends Fragment{
    ListView allContactList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_contact_fragment, null);

        RealmManager realmManager = new RealmManager();
        realmManager.getContact();

        allContactList = (ListView) view.findViewById(R.id.allContactList);
        AllContactAdapter allContactAdapter = new AllContactAdapter(getContext(), realmManager.getContact());
        allContactList.setAdapter(allContactAdapter);

        return view;
    }
}
