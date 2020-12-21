package com.example.tareaformulario;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.tareaformulario.databinding.ActivityMainBinding;
import com.example.tareaformulario.databinding.FragmentMain02Binding;
import com.example.tareaformulario.databinding.FragmentMainBinding;

public class MainFragment02 extends Fragment {
    private FragmentMain02Binding eBinding;
    private String eLog = MainFragment02.class.getSimpleName();

    public MainFragment02() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        eBinding = FragmentMain02Binding.inflate(inflater, container, false);
        return eBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        eBinding.radioGroup01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = eBinding.radioGroup01.indexOfChild
                        (eBinding.radioGroup01.findViewById(checkedId));
                switch (index){
                    case 0:
                        Toast.makeText(getContext(), "Otaku" ,Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(getContext(), "Eliminado!", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        eBinding = null;
    }
}