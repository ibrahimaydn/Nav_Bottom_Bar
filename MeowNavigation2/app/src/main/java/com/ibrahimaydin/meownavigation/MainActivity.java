package com.ibrahimaydin.meownavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;
    RelativeLayout main_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); // ActionBar'ı gizle


        main_layout = findViewById(R.id.main_layout);


        bottomNavigation = findViewById(R.id.bottomNavigation);
        replace(new HomeFragment());

        bottomNavigation.show(1, true);
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.baseline_home_24)); // anasayfa
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.baseline_camera_alt_24));  //kamera
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.baseline_videogame_asset_24)); //oyun
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.baseline_person_24));  //ayarlar


        meownavigation();
        main_layout.setBackgroundColor(Color.parseColor("#FF5722"));

    }

    public void kamera(View view) {
        //  Intent intent=new Intent(this,); //kameraya yolla


    }


    private void meownavigation() {

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                switch (model.getId()) {
                    case 1:
                        replace(new HomeFragment());
                        main_layout.setBackgroundColor(Color.parseColor("#FF5722"));
                        break;
                    case 2:
                        replace(new CameraFragment());
                        main_layout.setBackgroundColor(Color.parseColor("#FF9800"));
                        break;
                    case 3:
                        replace(new GameFragment());
                        main_layout.setBackgroundColor(Color.parseColor("#FFC107"));
                        break;
                    case 4:
                        replace(new SettingFragment());
                        main_layout.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                }
                return null;
            }
        });

    }

    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();

    }

}