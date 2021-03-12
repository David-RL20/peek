package com.mancillajair.app.peek;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.mancillajair.app.peek.loaders.WalkerRequestLoader;
import com.mancillajair.app.peek.menu.walker_message;
import com.mancillajair.app.peek.menu.walker_profile;

public class MainWalker extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_walker);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        new WalkerRequestLoader(this,1).execute();

        ImageView btnMessage,btnProfile;
        btnMessage = (ImageView) findViewById(R.id.ivIconMessage);
        btnProfile = (ImageView) findViewById(R.id.ivIconProfile);

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMessage = new Intent(MainWalker.this, walker_message.class);
                startActivity(goToMessage);
            }
        });
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToProfile = new Intent(MainWalker.this, walker_profile.class);
                startActivity(goToProfile);
            }
        });
    }
}
