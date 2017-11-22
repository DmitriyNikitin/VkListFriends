package com.example.appfragments.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.appfragments.R;

/**
 * Created by админ on 21.11.2017.
 */

public class NavigationFragment extends Fragment {

    Button addNewContactBtn;
    Button allContactBtn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navigation_fragment, null);

        addNewContactBtn = (Button) view.findViewById(R.id.addNewContacntBtn);
        allContactBtn = (Button) view.findViewById(R.id.allContactsBtn);

        View.OnClickListener btnListener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();

                switch(view.getId()){
                    case R.id.addNewContacntBtn:
                        ft.replace(R.id.navigationConteiner, new AddNewContactFragment());
                        break;

                    case R.id.allContactsBtn:
                        ft.replace(R.id.navigationConteiner, new AllContactFragment());
                        break;
                }
                ft.commit();
            }
        };

        addNewContactBtn.setOnClickListener(btnListener);
        allContactBtn.setOnClickListener(btnListener);

        return view;
    }
}
