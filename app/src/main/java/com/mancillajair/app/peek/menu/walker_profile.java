package com.mancillajair.app.peek.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mancillajair.app.peek.MainWalker;
import com.mancillajair.app.peek.R;
import com.mancillajair.app.peek.loaders.OneWalkerLoader;

public class walker_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walker_profile);
        new OneWalkerLoader(this,2).execute();

        ImageView btnHome,btnMessage;
        btnHome = (ImageView) findViewById(R.id.ivIconHome);
        btnMessage = (ImageView) findViewById(R.id.ivIconMessage);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHome = new Intent(walker_profile.this, MainWalker.class);
                startActivity(goToHome);
            }
        });
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMessage = new Intent(walker_profile.this, walker_message.class);
                startActivity(goToMessage);
            }
        });
    }
}
