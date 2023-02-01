package com.example.example3.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.example3.fragment.AFragment;
import com.example.example3.fragment.BFragment;
import com.example.example3.fragment.CFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    Fragment[] fragments = new Fragment[]{new AFragment(), new BFragment(), new CFragment()};

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments[position];
    }

    @Override
    public int getItemCount() {
        return fragments.length;
    }
}
