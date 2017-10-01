package com.example.vklistfriends;


/**
 * Created by админ on 12.09.2017.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

import static com.example.vklistfriends.R.id.imageView;


/**
     * Created by админ on 28.07.2017.
     */

    public class CustomListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater lInflater;
    ArrayList<ResponseModel> list;


    CustomListAdapter(Context context, ArrayList<ResponseModel> list) {
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
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        ResponseModel model = getModel(position);


        Picasso.with(context).load(model.photo100).into((ImageView) view.findViewById(R.id.imageView));

        ((TextView) view.findViewById(R.id.name)).setText(" " + model.firstName +" " + model.lastName);

        return view;
    }

    ResponseModel getModel(int position) {
        return ((ResponseModel) getItem(position));
    }


}
