package com.example.lab3_fragmentsapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DynamicFragment extends Fragment {

    private static final String TAG="MainActivity" ;
    TextView txt;


    public DynamicFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Dynamic Fragment onCreate: ");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        Log.i(TAG, "Dynamic Fragment onCreateView: ");
        return inflater.inflate(R.layout.fragment_dynamic, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "Dynamic Fragment onViewCreated: ");
        txt = view.findViewById(R.id.txtCounter);
        if (savedInstanceState != null)
        {
            txt.setText(savedInstanceState.getString("text_key", ""));
        }
    }

    public void updateCounter(int counter)
    {
        //to recive the counter from the static fragment and shoe it in its own txt
        txt.setText("Counter = "+counter);
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "Dynamic Fragment onStart: ");
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, "Dynamic Fragment onAttach: ");
    }




    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "Dynamic Fragment onResume: ");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "Dynamic Fragment onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "Dynamic Fragment onStop: ");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "Dynamic Fragment onSaveInstanceState: ");
        outState.putString("text_key", txt.getText().toString());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Dynamic Fragment onDestroy: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "Dynamic Fragment onDestroyView: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "Dynamic Fragment onDetach: ");
    }


}