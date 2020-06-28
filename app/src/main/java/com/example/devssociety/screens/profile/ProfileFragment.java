package com.example.devssociety.screens.profile;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.devssociety.R;
import com.example.devssociety.databinding.FragmentProfileBinding;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    FragmentProfileBinding profileBinding;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        profileBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_profile,
                container,
                false);

        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setElevation(0);
        profileBinding.userNamePro.setText("Omer Maki");

        return profileBinding.getRoot();
    }
}
