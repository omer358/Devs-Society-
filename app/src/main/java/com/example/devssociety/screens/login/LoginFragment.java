package com.example.devssociety.screens.login;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.devssociety.R;
import com.example.devssociety.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding loginBinding;
    private LoginViewModel viewModel;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        loginBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_login,container,
                false);

        loginBinding.setViewModel(viewModel);
        loginBinding.setLifecycleOwner(this);
//        loginBinding.login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                login(v);
//            }
//        });

        loginBinding.bSginUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).
                        navigate(R.id.action_global_homePage);
            }
        });

        return loginBinding.getRoot();
    }

//    private void login(View v) {
//
//        String userName = loginBinding.editTextUserName.getText().toString();
//
//        if (!userName.isEmpty() && !userName.equals(" ")) {
////            Bundle bundle = new Bundle();
////            bundle.putString("UserName",userName);
////            Navigation.findNavController(v).
////                    navigate(R.id.action_loginFragment_to_nav_home_graph,bundle);
//            Intent intent = new Intent(getContext(),Home.class);
//            intent.putExtra("username",userName);
//            startActivity(intent);
//        }else {
//            loginBinding.textInputLayoutUser.setError(getString(R.string.enter_userName));
//        }
//    }

    //    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        loginBinding.login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String userName = loginBinding.editTextUserName.getText().toString();
//
//                if (!userName.equals("") && userName!=null){
////                Toast.makeText(MainActivity.this,editText.getText(),Toast.LENGTH_LONG).show();
//
//                    Intent profileActivity = new Intent(getContext(),Profile.class);
//                    profileActivity.putExtra(Profile.USER_NAME_ACTION,userName);
//                    startActivity(profileActivity);
//                }else {
//                    loginBinding.textInputLayoutUser.setError("enter the username!");
//                }
//            }
//        });
//
//        loginBinding.bSginUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sginUpActivity = new Intent(getContext(),SignUpActivity.class);
//                startActivity(sginUpActivity);
//            }
//        });
//
//    }
}
