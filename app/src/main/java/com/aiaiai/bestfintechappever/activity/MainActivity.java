package com.aiaiai.bestfintechappever.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.aiaiai.bestfintechappever.R;
import com.aiaiai.bestfintechappever.base.BaseActivity;
import com.aiaiai.bestfintechappever.fragment.FirstFragment;
import com.aiaiai.bestfintechappever.fragment.SecondFragment;
import com.aiaiai.bestfintechappever.fragment.ThirdFragment;

public class MainActivity extends BaseActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    loadFragment(FirstFragment.instance());
                    return true;
                case R.id.navigation_dashboard:
                    loadFragment(SecondFragment.instance());
                    return true;
                case R.id.navigation_notifications:
                    loadFragment(ThirdFragment.instance());
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        loadFragment(FirstFragment.instance());
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
