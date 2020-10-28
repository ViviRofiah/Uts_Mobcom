package com.example.belajarkuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout, new homepage()).commit();
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.neg_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;

                    switch (item.getItemId()){
                        case R.id.addcounterpage:
                            fragment = new homepage();
                            break;

                        case R.id.firstcounterpage:
                            fragment = new firstsecond_fragment();
                            break;

                        case R.id.secondcounterpage:
                            fragment = new secondcounter_fragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout, fragment).commit();
                    return true;
                }
            };


}