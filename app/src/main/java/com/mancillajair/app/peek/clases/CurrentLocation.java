package com.mancillajair.app.peek.clases;
import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;

import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class CurrentLocation {
    private LatLng currentLocation ;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;
    private Activity activity;

    public static int getRequestCode() { return REQUEST_CODE; }

    public LatLng getCurrentLocation() { return currentLocation; }
    public void setCurrentLocation(LatLng currentLocation) { this.currentLocation = currentLocation; }

    public FusedLocationProviderClient getFusedLocationProviderClient() { return fusedLocationProviderClient; }
    public void setFusedLocationProviderClient(FusedLocationProviderClient fusedLocationProviderClient) { this.fusedLocationProviderClient = fusedLocationProviderClient; }

    public Activity getActivity() { return activity; }
    public void setActivity(Activity activity) { this.activity = activity; }

    public void fetchLastLocation() {
        if(ActivityCompat.checkSelfPermission(activity.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION )!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.ACCESS_FINE_LOCATION },REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                    currentLocation = new LatLng(location.getLatitude(),location.getLongitude());
                }
            }
        });
    }
    public CurrentLocation(){
        this.currentLocation = new LatLng(0,0);
    }
}
