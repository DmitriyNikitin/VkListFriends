package com.example.vklistfriends;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.vklistfriends.PhotoFriends.PhotoModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by админ on 08.10.2017.
 */

public class PhotoAdapter extends BaseAdapter {

    Context context;
    LayoutInflater lInflater;
    ArrayList<PhotoModel> list;

    PhotoAdapter(Context context, ArrayList<PhotoModel> list) {
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
            view = lInflater.inflate(R.layout.photo_item, parent, false);
        }

        PhotoModel model = getModel(position);

        Picasso.with(context).load(model.srcBig).into((ImageView) view.findViewById(R.id.imagePhoto));

        return view;
    }

    PhotoModel getModel(int position) {
        return ((PhotoModel) getItem(position));
    }
}