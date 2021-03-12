package com.mancillajair.app.peek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.mancillajair.app.peek.clases.ItemNearWalker;
import com.mancillajair.app.peek.menu.Dog;
import com.mancillajair.app.peek.menu.Messages;
import com.mancillajair.app.peek.menu.Profile;
import com.mancillajair.app.peek.menu.Search;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener {
    Location currentLocation ;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;
    private GoogleMap mMap;
    private ImageView ivIconGoToSearch,ivIconGoToDog,ivIconMessage,ivIconProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //nav
        ivIconGoToSearch = (ImageView) findViewById(R.id.ivIconSearch);
        ivIconGoToDog = (ImageView) findViewById(R.id.ivIconDog);
        ivIconMessage = (ImageView)findViewById(R.id.ivIconMessage);
        ivIconProfile = (ImageView)findViewById(R.id.ivIconProfile);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        ivIconGoToSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToSearch = new Intent(MainActivity.this, Search.class);
                startActivity(intentGoToSearch);
            }
        });

        ivIconGoToDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToDog = new Intent(MainActivity.this, Dog.class);
                startActivity(intentGoToDog);
            }
        });

        ivIconMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoToMessage = new Intent(MainActivity.this, Messages.class);
                startActivity(intentGoToMessage);
            }
        });
        ivIconProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoToProfile = new Intent(MainActivity.this, Profile.class);

                startActivity(intentGoToProfile);
            }
        });

        fetchLastLocation();
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this,"En el boton de localizacion",Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this,"Mi location : \n "+location.getLatitude()+' '+location.getLongitude(),Toast.LENGTH_LONG).show();
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(),location.getLongitude()),16));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //Map assign
        mMap = googleMap;
        //current location
        LatLng latLng = new LatLng(123.445,432.4);
        //zoom to current location
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,12));

        try {
            MapStyleOptions style =  MapStyleOptions.loadRawResourceStyle(this,R.raw.style_json);
            mMap.setMapStyle(style);
        }catch (Exception e){
            Log.e("OnMapReady",e.getMessage());
        }
        // Enable button
        mMap.setMyLocationEnabled(true);
        //on click
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
    }

    private void fetchLastLocation() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION )!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION },REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                    currentLocation = location;
                    Toast.makeText(getApplicationContext(),currentLocation.getLatitude()+
                            " "+currentLocation.getLongitude(),Toast.LENGTH_SHORT).show();
                    SupportMapFragment supportMapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
                    setNearWalkerEventListener();
                    supportMapFragment.getMapAsync(MainActivity.this );
                }else{
                    Toast.makeText(getApplicationContext(),"La ubicacion no se ha conseguido",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    fetchLastLocation();
                }
                break;
        }
    }

    public void setNearWalkerEventListener(){
        Button btn_SearchWalker = (Button) findViewById(R.id.btnSearchWalker);
        btn_SearchWalker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Buscando paseador",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, ItemNearWalker.class);
                intent.putExtra("latitud",currentLocation.getLatitude());
                intent.putExtra("longitud",currentLocation.getLongitude());
                startActivity(intent);
            }
        });
    }
}
