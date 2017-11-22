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


        View.OnClickListener navigationListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                switch (view.getId()) {
                    case R.id.call :
                        ft.replace(R.id.navigationContainer, new CallFragment());
                        break;
                    case R.id.favorite:
                        ft.replace(R.id.navigationContainer, new FavoriteFragment());
                        break;
                    case R.id.groups:
                        ft.replace(R.id.navigationContainer, new GroupFragment());
                        break;

                }
                ft.commit();
            }
        };
        callBtn.setOnClickListener(navigationListener);
        favoriteBtn.setOnClickListener(navigationListener);
        groupBtn.setOnClickListener(navigationListener);

        return view;

    }


}
