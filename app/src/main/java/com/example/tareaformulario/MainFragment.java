package com.example.tareaformulario;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.tareaformulario.databinding.FragmentMainBinding;

import java.text.Bidi;

public class MainFragment extends Fragment {
    private FragmentMainBinding eBiding;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        eBiding = FragmentMainBinding.inflate(inflater, container, false);
        return eBiding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        eBiding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = eBiding.radioGroup.indexOfChild(eBiding.radioGroup.findViewById(checkedId));

                switch (index){
                    case 0:
                        eBiding.tvFragmewnt.setText("Hola Mundo");
                        break;
                    case 1:
                        eBiding.tvFragmewnt.setText("Adios Mundo");
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public static MainFragment newInstance(){
        MainFragment fragmento = new MainFragment();
        return fragmento;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        eBiding = null;
    }
}