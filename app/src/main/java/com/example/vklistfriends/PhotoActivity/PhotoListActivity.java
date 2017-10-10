package com.example.vklistfriends.PhotoActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.example.vklistfriends.Managers.FriendsManager;
import com.example.vklistfriends.PhotoFriends.PhotoInterface;
import com.example.vklistfriends.Models.PhotoModel;
import com.example.vklistfriends.R;

import java.util.ArrayList;

public class PhotoListActivity extends AppCompatActivity {

    Integer ownerId;
    String albumId = "profile";
    Integer rev = 1;
    Integer photoSizes = 1;
    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        FriendsManager fM = new FriendsManager();
        Intent intent = getIntent();
        grid = (GridView)findViewById(R.id.grid);

        ownerId = intent.getIntExtra("ownerId", 0);

        fM.getPhotoFriend(ownerId, albumId, rev, photoSizes, new PhotoInterface() {
            @Override
            public void ifSuccess(ArrayList<PhotoModel> arrayList) {
                if (arrayList == null) {
                        Toast.makeText(PhotoListActivity.this, "У данного пользователя нет фотографий.", Toast.LENGTH_LONG).show();
                } else {
                    PhotoAdapter photoAdapter = new PhotoAdapter(PhotoListActivity.this, arrayList);
                    grid.setAdapter(photoAdapter);
                }
            }

            @Override
            public void ifFailed() {
            }
        });
}
}
