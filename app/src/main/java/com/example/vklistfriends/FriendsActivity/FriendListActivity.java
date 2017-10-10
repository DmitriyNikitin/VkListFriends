package com.example.vklistfriends.FriendsActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vklistfriends.Managers.AuthManager;
import com.example.vklistfriends.Managers.FriendsManager;
import com.example.vklistfriends.Models.ResponseModel;
import com.example.vklistfriends.PhotoActivity.PhotoListActivity;
import com.example.vklistfriends.R;

import java.util.ArrayList;

public class FriendListActivity extends AppCompatActivity{


    ListView listView;
    ArrayList<ResponseModel> infoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_friend);

        listView = (ListView) findViewById(R.id.listFriend);
        AuthManager aM = new AuthManager(this);

        FriendsManager fM = new FriendsManager(aM.getToken());

        fM.fetch(new FriendsInterface() {
            @Override
            public void ifSuccess(ArrayList<ResponseModel> arrayList) {
                infoList = arrayList;
                CustomListAdapter cLA = new CustomListAdapter(FriendListActivity.this, arrayList);
                listView.setAdapter(cLA);
            }

            @Override
            public void ifFailed() {
                Toast.makeText(FriendListActivity.this, "Проверьте соединение с сетью!", Toast.LENGTH_LONG).show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentClick = new Intent(FriendListActivity.this, PhotoListActivity.class);
                Integer uid = infoList.get(position).uid;
                intentClick.putExtra("ownerId", uid);
                startActivity(intentClick);
            }
        });
    }
}
