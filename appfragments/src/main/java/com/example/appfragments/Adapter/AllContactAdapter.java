package com.example.appfragments.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appfragments.R;
import com.example.appfragments.Realm.RealmModel.ContactModel;

import java.util.ArrayList;

/**
 * Created by админ on 22.11.2017.
 */

public class AllContactAdapter extends BaseAdapter
{
    Context context;
    LayoutInflater lInflater;
    ArrayList<ContactModel> list;

    public AllContactAdapter(Context context, ArrayList<ContactModel> list) {
        this.context = context;
        this.list = list;

        lInflater = (LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.d("", "");
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.list_item_contacnt, parent, false);
        }

        ContactModel contactModel = getModel(position);


        ((TextView) view.findViewById(R.id.firstName)).setText(contactModel.getFirstName());
        ((TextView) view.findViewById(R.id.lastName)).setText(contactModel.getLastName());
        ((TextView) view.findViewById(R.id.telefon)).setText(contactModel.getTelefon());

        return view;
    }

    ContactModel getModel(int position) {
        return ((ContactModel) getItem(position));
    }



}