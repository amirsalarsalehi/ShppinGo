package com.example.shoppingo.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.shoppingo.R;
import com.example.shoppingo.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
    }

    private void initView() {
        NavigationUI.setupWithNavController(binding.bottomNav, Navigation.findNavController(this, R.id.fragment));

        Navigation.findNavController(this, R.id.fragment).addOnDestinationChangedListener((controller, destination, arguments) -> {
            switch (destination.getId()) {
                case R.id.signUpFragment:
                case R.id.loginFragment:
                case R.id.forgotPasswordFragment:
                    binding.bottomNav.setVisibility(View.GONE);
                    binding.bottomNav.animate().translationYBy(0).translationY(100f).setDuration(0).start();
                    break;
                default:
                    binding.bottomNav.setVisibility(View.VISIBLE);
                    binding.bottomNav.animate().translationYBy(100f).translationY(0).setDuration(300).start();
                    break;
            }
        });
    }

}