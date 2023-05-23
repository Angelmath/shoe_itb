package com.example.myapplication.ui.quienes_somos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentQuienesSomosBinding;

public class QuienesSomosFragment extends Fragment {

    private FragmentQuienesSomosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        QuienesSomosViewModel galleryViewModel =
                new ViewModelProvider(this).get(QuienesSomosViewModel.class);

        binding = FragmentQuienesSomosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}