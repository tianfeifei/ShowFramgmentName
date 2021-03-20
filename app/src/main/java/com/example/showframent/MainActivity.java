package com.example.showframent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment1();
        initFragment2();
    }


    private void initFragment1() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment1 fragment = ((Fragment1) Fragment.instantiate(this, Fragment1.class.getName(), null));
        fragment.setUserVisibleHint(true);
        fragmentTransaction.replace(R.id.fl1, fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void initFragment2() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment2 fragment = ((Fragment2) Fragment.instantiate(this, Fragment2.class.getName(), null));
        fragment.setUserVisibleHint(true);
        fragmentTransaction.replace(R.id.fl2, fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }
}