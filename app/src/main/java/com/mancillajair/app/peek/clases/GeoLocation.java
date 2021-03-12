package com.mancillajair.app.peek.clases;

import android.Manifest;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.model.LatLng;

public class GeoLocation extends FragmentActivity {
    private double latitud;
    private double longitud;

    public double getLatituted() { return latitud; }
    public void setLatitud(double latitud) { this.latitud = latitud; }

    public double getLongitud() { return longitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }

    public GeoLocation(){
        this.longitud =0.0;
        this.latitud=0.0;
    }
    public GeoLocation( double latitud, double longitud){
        this.latitud=latitud;
        this.longitud=longitud;
    }
    public String ToString(){
        return (this.longitud+" , "+this.latitud);
    }
}
