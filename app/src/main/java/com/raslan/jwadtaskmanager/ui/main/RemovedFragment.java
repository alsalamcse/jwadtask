package com.raslan.jwadtaskmanager.ui.main;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raslan.jwadtaskmanager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RemovedFragment extends Fragment {


    public RemovedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_removed, container, false);
    }

}
