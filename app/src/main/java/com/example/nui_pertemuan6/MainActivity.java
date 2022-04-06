package com.example.nui_pertemuan6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getTabs();
    }

    public void getTabs() {
        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                viewPagerAdapter.addFragment(Tab1Fragment.getInstance(), "Tab 1");
                viewPagerAdapter.addFragment(Tab2Fragment.getInstance(), "Tab 2");
                viewPagerAdapter.addFragment(Tab3Fragment.getInstance(), "Tab 3");
                viewPager.setAdapter(viewPagerAdapter);
                tabLayout.setupWithViewPager(viewPager);

                tabLayout.getTabAt(0).setIcon(R.drawable.alert_toast);
                tabLayout.getTabAt(1).setIcon(R.drawable.listview);
                tabLayout.getTabAt(2).setIcon(R.drawable.activity);
            }
        });
    }

    public void ShowToast(View view) {
        Toast toast = Toast.makeText(this, "Ini adalah pesan Toast", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }


    public void ShowAlert(View view) {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("Title Alert Dialog")
                .setMessage("Message Alert Dialog")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Kamu memilih OK", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

}