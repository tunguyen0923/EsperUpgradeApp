package com.example.esperupgradeapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.esperupgradeapp.databinding.ActivityMainBinding;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button btnUpgradeEsper = findViewById(R.id.button);
        btnUpgradeEsper.setOnClickListener(view -> {

            // You can change or upload load Esper ISO file to this
            Uri uri = Uri.parse("file:///storage/emulated/0/Download/foundation-11.5.0.1259-x86_64-baremetal-20230228-ncr-OFFICIAL-REL_1-k5.10.iso");
            File f = new File(uri.getPath());
            f.setReadable(true, false);

            Intent in = new Intent("com.ncr.android.os_flip_service.NCR_COPYUPDATE");
            in.putExtra("UpdateFilename", f.getAbsolutePath());
            startActivity(in);

            in = new Intent("com.ncr.android.os_flip_service.NCR_UPDATE_PROCESS");
            startActivity(in);
        });
    }
}