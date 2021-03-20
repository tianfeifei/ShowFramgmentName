package com.example.showframent.base;


import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.showframent.ForegroundDrawable;
import com.example.showframent.R;

public class FragmentBase extends Fragment {
    @Override
    public void onResume() {
        super.onResume();
        View view = getView();
        ForegroundDrawable foregroundDrawable = new ForegroundDrawable(getResources().getColor(R.color.black),getContext().getClass().getSimpleName());
        view.setForeground(foregroundDrawable);
    }
}
