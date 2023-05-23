package com.example.myapplication.ui.informacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentInformativoBinding;

import java.util.ArrayList;

public class InformacionFragment extends Fragment {

    private FragmentInformativoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InformacionViewModel homeViewModel =
                new ViewModelProvider(this).get(InformacionViewModel.class);

        binding = FragmentInformativoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ImageView bgImage = binding.imageView2;
        ArrayList<Integer> imagenes = new ArrayList<>();
        imagenes.add(R.drawable.tarea1);
        imagenes.add(R.drawable.tarea2);
        imagenes.add(R.drawable.tarea3);
        new Runnable() {
            int updateInterval = 2500; //=one second
            int val = 0;
            @Override
            public void run() {
                bgImage.setImageResource(imagenes.get(val));
                val++;
                // Any code which goes here will be executed every 'updateInterval'
                // change your background here

                bgImage.postDelayed(this, updateInterval);
                if(val==3) val=0;
            }
        }.run();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}