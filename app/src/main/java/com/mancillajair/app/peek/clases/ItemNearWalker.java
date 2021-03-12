package com.mancillajair.app.peek.clases;

import android.os.Bundle;
import android.os.StrictMode;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.model.LatLng;
import com.mancillajair.app.peek.R;
import com.mancillajair.app.peek.loaders.GetNearWalkerLoader;

public class ItemNearWalker extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_walker_near);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Bundle bundle = this.getIntent().getExtras();
        LatLng location = new LatLng(bundle.getDouble("latitud"),bundle.getDouble("longitud"));
        new GetNearWalkerLoader(ItemNearWalker.this , location).execute();
    }
}
