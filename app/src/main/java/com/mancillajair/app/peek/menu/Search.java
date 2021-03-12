package com.mancillajair.app.peek.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.mancillajair.app.peek.MainActivity;
import com.mancillajair.app.peek.R;
import com.mancillajair.app.peek.loaders.WalkerLoader;


public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ImageView ivIconGoToDog,ivIconHome,ivIconMessage,ivIconProfile;
        //nav
        ivIconGoToDog = (ImageView) findViewById(R.id.ivIconDog);
        ivIconHome = (ImageView)findViewById(R.id.ivIconHome);
        ivIconMessage = (ImageView)findViewById(R.id.ivIconMessage);
        ivIconProfile = (ImageView)findViewById(R.id.ivIconProfile);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        ivIconGoToDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToDog = new Intent(Search.this, Dog.class);
                startActivity(intentGoToDog);
            }
        });
        ivIconHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoToHome = new Intent(Search.this, MainActivity.class);
                startActivity(intentGoToHome);
            }
        });
        ivIconMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoToMessage = new Intent(Search.this, Messages.class);
                startActivity(intentGoToMessage);
            }
        });
        ivIconProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoToProfile = new Intent(Search.this, Profile.class);
                startActivity(intentGoToProfile);
            }
        });
        //loader
        new WalkerLoader(this).execute();
    }
}
