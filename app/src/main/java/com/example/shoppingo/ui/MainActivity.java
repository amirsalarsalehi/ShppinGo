package com.example.shoppingo.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.shoppingo.R;
import com.example.shoppingo.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.distribute.Distribute;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private int currentFragment = 0;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        AppCenter.start(getApplication(), "0f497517-9d7f-4194-a6c2-9a7c475f7209",
                Analytics.class, Crashes.class, Distribute.class);
        AppCenter.setLogLevel(Log.VERBOSE);

        initView();
    }

    private void initView() {
        NavigationUI.setupWithNavController(binding.bottomNav, Navigation.findNavController(this, R.id.fragment));

        Navigation.findNavController(this, R.id.fragment).addOnDestinationChangedListener((controller, destination, arguments) -> {
            currentFragment = destination.getId();
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

        binding.bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navMain:
                        if (currentFragment != R.id.mainFragment) {
                            Navigation.findNavController(MainActivity.this, R.id.fragment)
                                    .navigate(R.id.mainFragment, null, new NavOptions.Builder()
                                            .setPopUpTo(R.id.mainFragment, true)
                                            .build());
                            return true;
                        }
                    case R.id.navShop:
                        if (currentFragment != 1) {
                            return true;
                        }
                    case R.id.navBag:
                        if (currentFragment != 1) {
                            return true;
                        }
                    case R.id.navFav:
                        if (currentFragment != 1) {
                            return true;
                        }
                    case R.id.navProfile:
                        if (currentFragment != 1) {
                            return true;
                        }
                }
                return false;
            }
        });
    }
}