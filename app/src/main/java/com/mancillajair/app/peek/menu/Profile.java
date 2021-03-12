package com.mancillajair.app.peek.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.mancillajair.app.peek.MainActivity;
import com.mancillajair.app.peek.MainWalker;
import com.mancillajair.app.peek.R;
import com.mancillajair.app.peek.clases.Owner;
import com.mancillajair.app.peek.loaders.OwnerLoader;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView ivIconGoToSearch,ivIconGoToDog,ivIconHome,ivIconMessage;
        Button btnGoToWalker = (Button) findViewById(R.id.btnGoToWalker);
        //nav
        ivIconGoToSearch = (ImageView) findViewById(R.id.ivIconSearch);
        ivIconGoToDog = (ImageView) findViewById(R.id.ivIconDog);
        ivIconHome = (ImageView)findViewById(R.id.ivIconHome);
        ivIconMessage = (ImageView)findViewById(R.id.ivIconMessage);

        btnGoToWalker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToWalker = new Intent(Profile.this, MainWalker.class);
                startActivity(goToWalker);
            }
        });

        ivIconGoToSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToSearch = new Intent(Profile.this, Search.class);
                startActivity(intentGoToSearch);
            }
        });

        ivIconGoToDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToDog = new Intent(Profile.this, Dog.class);
                startActivity(intentGoToDog);
            }
        });
        ivIconHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoToHome = new Intent(Profile.this, MainActivity.class);
                startActivity(intentGoToHome);
            }
        });
        ivIconMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoToMessage = new Intent(Profile.this, Messages.class);
                startActivity(intentGoToMessage);
            }
        });

        new OwnerLoader(this).execute();
    }
}
