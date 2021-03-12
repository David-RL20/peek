package com.mancillajair.app.peek.menu;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mancillajair.app.peek.MainWalker;
import com.mancillajair.app.peek.R;

public class walker_message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walker_message);

        ImageView btnHome,btnProfile;
        btnHome = (ImageView) findViewById(R.id.ivIconHome);
        btnProfile = (ImageView) findViewById(R.id.ivIconProfile);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHome = new Intent(walker_message.this, MainWalker.class);
                startActivity(goToHome);
            }
        });
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToProfile = new Intent(walker_message.this, walker_profile.class);
                startActivity(goToProfile);
            }
        });
    }
}
