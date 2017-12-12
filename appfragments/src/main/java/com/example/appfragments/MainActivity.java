package com.example.appfragments;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.appfragments.fragments.NavigationFragment;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    public final String NAVIGATION_TAG = "navigationFragment";
    NavigationFragment navigationFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);

        navigationFragment = new NavigationFragment();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
       if(!navigationFragment.isAdded()) {
            ft.add(R.id.mainContainer, navigationFragment, NAVIGATION_TAG);
       }
        ft.commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if(navigationFragment.isAdded()) {
            ft.remove(navigationFragment);
        }
        ft.commit();

    }
}
