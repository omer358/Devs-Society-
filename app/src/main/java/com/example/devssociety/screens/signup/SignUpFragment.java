package com.example.devssociety.screens.signup;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.devssociety.R;
import com.example.devssociety.databinding.FragmentSignUpBinding;

import static android.app.Activity.RESULT_OK;

public class SignUpFragment extends Fragment {

    private final static int REQUEST_IMAGE_CAPTURE = 1;
    private final static int REQUEST_GALLERY_PICKER = 2;
    private static final String TAG = "SignUpFragment";
    FragmentSignUpBinding signUpBinding;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        signUpBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_sign_up,
                container,
                false
        );
        signUpBinding.openGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(openGalleryIntent, REQUEST_GALLERY_PICKER);
            }
        });

        signUpBinding.takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });

        return signUpBinding.getRoot();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "the result code:" + resultCode);
        Log.d(TAG, "the request code:" + requestCode);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            signUpBinding.editProfile.setImageBitmap(imageBitmap);
            Toast.makeText(getContext(), "it works", Toast.LENGTH_LONG).show();
        } else if (requestCode == REQUEST_GALLERY_PICKER && resultCode == RESULT_OK) {
            Uri imageUri = data.getData();
            signUpBinding.editProfile.setImageURI(imageUri);
        }
    }

    private void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } else {
            Toast.makeText(getContext(), "There is no App to handle this task!", Toast.LENGTH_LONG).show();
        }
    }
}
