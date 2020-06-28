package com.example.devssociety;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.devssociety.R;
import com.example.devssociety.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);

        NavController navController = Navigation.
                findNavController(this,
                        R.id.nav_host_fragment_container);
        BottomNavigationView bottomNav = mainBinding.bottomNav;
        NavigationUI.setupWithNavController(bottomNav,navController);
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this,
//                R.id.nav_host_fragment_container);
//        return navController.navigateUp();
//    }
}
