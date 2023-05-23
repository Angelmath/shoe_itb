package com.example.myapplication.ui.contactenos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentContactenosBinding;

import java.util.List;

public class ContactenosFragment extends Fragment {

    private FragmentContactenosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ContactenosViewModel galleryViewModel =
                new ViewModelProvider(this).get(ContactenosViewModel.class);

        binding = FragmentContactenosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final Spinner spinner3 = binding.spinner3;
        String[] categorias = {"Guayaquil", "Manta"};
        spinner3.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, categorias));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}