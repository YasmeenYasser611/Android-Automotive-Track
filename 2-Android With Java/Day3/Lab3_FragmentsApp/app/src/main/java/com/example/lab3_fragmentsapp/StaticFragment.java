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
import android.widget.Button;

public class StaticFragment extends Fragment {
    private static final String TAG="MainActivity" ;
    private int Counter =0;
    Communicator comm ;



    public StaticFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, "Fragment onAttach: ");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Fragment onCreate: ");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(TAG, "Fragment onCreateView: ");
        return inflater.inflate(R.layout.fragment_static, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {

        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "Fragment onViewCreated: ");
        comm = (Communicator) getActivity();
        if (savedInstanceState != null)
        {
            Counter = savedInstanceState.getInt("counter_key", 0);
        }

        Button btn = view.findViewById(R.id.StaticBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Counter++;
                comm.count(Counter);

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "Fragment onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "Fragment onResume: ");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "Fragment onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "Fragment onStop: ");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "Fragment onSaveInstanceState: ");
        outState.putInt("counter_key", Counter); // Increment and save
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Fragment onDestroy: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "Fragment onDestroyView: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "Fragment onDetach: ");
    }
}