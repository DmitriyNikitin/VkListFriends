package com.example.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by админ on 12.11.2017.
 */

public class NavigationFragment extends Fragment{
    NavigationFragment navigationFragment;
    View view;
    Button callBtn;
    Button favoriteBtn;
    Button groupBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.navigation, container, false);

        callBtn = (Button)view.findViewById(R.id.call);
        favoriteBtn = (Button)view.findViewById(R.id.favorite);
        groupBtn = (Button)view.findViewById(R.id.groups);

       callBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
            new NavigationFragment().showCallFragment(R.id.navigationContainer, getActivity());
           }
       });

        favoriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new NavigationFragment().showFavoriteFragment(R.id.navigationContainer, getActivity());
            }
        });

        groupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new NavigationFragment().showGroupFragment(R.id.navigationContainer, getActivity());
            }
        });
        return view;

    }

    public void showNavigationFragment(int resId, FragmentActivity activity){
        navigationFragment = new NavigationFragment();
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.replace(resId, navigationFragment);
        ft.commit();
    }

    public void showCallFragment(int resId, FragmentActivity parentFragment){
        FragmentTransaction ft = parentFragment.getSupportFragmentManager().beginTransaction();
        ft.replace(resId, new CallFragment());
        ft.commit();
    }

    public void showFavoriteFragment(int resId, FragmentActivity parentFragment){
        FragmentTransaction ft = parentFragment.getSupportFragmentManager().beginTransaction();
        ft.replace(resId, new FavoriteFragment());
        ft.commit();
    }

    public void showGroupFragment(int resId, FragmentActivity parentFragment){
        FragmentTransaction ft = parentFragment.getSupportFragmentManager().beginTransaction();
        ft.replace(resId, new GroupFragment());
        ft.commit();
    }

}
