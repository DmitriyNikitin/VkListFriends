package com.example.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by админ on 13.11.2017.
 */

public class FavoriteFragment extends Fragment {

    private Button callBtn;
    private Button groupBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favorite, null);
        callBtn =(Button) view.findViewById(R.id.callBtn);
        groupBtn=(Button)view.findViewById(R.id.groupsBtn);

        View.OnClickListener replaseListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                switch (view.getId()){
                    case R.id.callBtn:
                        ft.replace(R.id.favoriteContainer, new CallFragment());
                        break;

                    case R.id.groupsBtn:
                        ft.replace(R.id.favoriteContainer, new GroupFragment());
                        break;
                }
                ft.commit();
            }
        };
        callBtn.setOnClickListener(replaseListener);
        groupBtn.setOnClickListener(replaseListener);

        return view;
    }
}
