package com.mancillajair.app.peek.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.mancillajair.app.peek.MainActivity;
import com.mancillajair.app.peek.R;

public class Messages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        ImageView ivIconGoToSearch,ivIconGoToDog,ivIconHome,ivIconProfile;
        //nav
        ivIconGoToSearch = (ImageView) findViewById(R.id.ivIconSearch);
        ivIconGoToDog = (ImageView) findViewById(R.id.ivIconDog);
        ivIconHome = (ImageView)findViewById(R.id.ivIconHome);
        ivIconProfile = (ImageView)findViewById(R.id.ivIconProfile);

        ivIconGoToSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToSearch = new Intent(Messages.this, Search.class);
                startActivity(intentGoToSearch);
            }
        });

        ivIconGoToDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToDog = new Intent(Messages.this, Dog.class);
                startActivity(intentGoToDog);
            }
        });
        ivIconHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoToHome = new Intent(Messages.this, MainActivity.class);
                startActivity(intentGoToHome);
            }
        });

        ivIconProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoToProfile = new Intent(Messages.this, Profile.class);
                startActivity(intentGoToProfile);
            }
        });
    }
}
