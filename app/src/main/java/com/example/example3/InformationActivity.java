package com.example.example3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

import com.example.example3.adapter.ViewPagerAdapter;
import com.example.example3.databinding.ActivityInformationBinding;
import com.example.example3.fragment.AFragment;
import com.example.example3.fragment.BFragment;
import com.example.example3.fragment.CFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

public class InformationActivity extends AppCompatActivity {

    ActivityInformationBinding binding;
    Fragment aFragment, bFragment, cFragment;
    ViewPager2 viewPager2;
    ViewPagerAdapter adapter;

    String[] str = new String[] { "TAB1", "TAB2", "TAB3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        //Fragment
        aFragment = new AFragment();
        bFragment = new BFragment();
        cFragment = new CFragment();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.viewPager);

        adapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TextView textView = new TextView(InformationActivity.this);
                textView.setText(str[position]);
                textView.setGravity(Gravity.CENTER);
                tab.setCustomView(textView);
            }
        }).attach();

    }
}