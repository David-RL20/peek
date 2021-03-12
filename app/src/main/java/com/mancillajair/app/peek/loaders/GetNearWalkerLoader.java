
package com.mancillajair.app.peek.loaders;


import android.app.Activity;

import android.os.AsyncTask;

import android.util.Log;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;
import com.mancillajair.app.peek.R;
import com.mancillajair.app.peek.adapters.WalkerAdapter;
import com.mancillajair.app.peek.clases.GeoLocation;
import com.mancillajair.app.peek.clases.Historial;
import com.mancillajair.app.peek.clases.Walker;

import org.json.JSONArray;
import org.json.JSONException;

import org.json.JSONObject;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import java.net.MalformedURLException;

import java.net.URL;

import java.util.ArrayList;


public class GetNearWalkerLoader extends AsyncTask<String,Void, ArrayList<Walker>> {

    private Activity activity;

    private LatLng location;

    public GetNearWalkerLoader(Activity activity , LatLng latLng){

        this.activity= activity;

        this.location = latLng;

    }

    @Override

    protected ArrayList<Walker> doInBackground(String... strings) {

        ArrayList<Walker> walkers = new ArrayList<>();


        //connect to API

        InputStream data = null;

        String responseText="";

        HttpURLConnection connection = null;

        try{

            URL url = new URL("https://peek2020.000webhostapp.com/AllWalkers.php?latitud="+this.location.latitude+"&longitud="+this.location.longitude);

            connection = (HttpURLConnection)url.openConnection();

            Log.d("Connection","Successfully established connection");


            data = connection.getInputStream();// get data

            StringBuilder rawData = new StringBuilder();

            BufferedReader reader =  new BufferedReader(new InputStreamReader(data));


            //read lines

            String dataline = "";

            while((dataline = reader.readLine()) != null){

                rawData.append(dataline);//add text to string builder


            }

            responseText = rawData.toString();

            Log.d("Response Walker", responseText);

        }catch (MalformedURLException ex){

            Log.e("URL Exception",ex.getMessage());

        }catch (IOException ex){

            Log.e("IO Exception",ex.getMessage());

        }catch (Exception ex){

            Log.e("General Exception",ex.getMessage());

        }

        finally{

            if(connection != null) connection.disconnect();

        }

        //parse to JSON

        JSONArray jsonWalker = null;

        try{

            jsonWalker = new JSONArray(responseText);

            //read array

            for (int i=0;i<jsonWalker.length();i++){

                //get objects within objects

                JSONObject Obj_Walker = jsonWalker.getJSONObject(i);

                JSONObject Obj_CurrentLocation = Obj_Walker.getJSONObject("currentLocation");

                JSONObject Obj_RouteStar = Obj_Walker.getJSONObject("pointStar");

                JSONObject Obj_RouteEnd = Obj_Walker.getJSONObject("pointFinish");

                JSONArray  Arr_Historic = Obj_Walker.getJSONArray("historial");

                //create a walker

                Walker w = new Walker();

                //Elements for Walker

                GeoLocation currentLocation = new GeoLocation(Obj_CurrentLocation.getDouble("latitud"),Obj_CurrentLocation.getDouble("longitud"));

                GeoLocation route_star = new GeoLocation(Obj_RouteStar.getDouble("latitud"),Obj_RouteStar.getDouble("longitud"));

                GeoLocation route_end = new GeoLocation(Obj_RouteEnd.getDouble("latitud"),Obj_RouteEnd.getDouble("longitud"));

                ArrayList<Historial> historials = new ArrayList<Historial>();



                if (Arr_Historic.length() != 0){

                    for(int j =0;i<Arr_Historic.length();i++){

                        JSONObject Obj_Histories = Arr_Historic.getJSONObject(j);

                        JSONObject obj_star = Obj_Histories.getJSONObject("star");

                        JSONObject obj_end = Obj_Histories.getJSONObject("star");


                        Historial history = new Historial();

                        GeoLocation star = new GeoLocation(obj_star.getDouble("latitud"),obj_star.getDouble("longitud"));

                        GeoLocation end = new GeoLocation(obj_end.getDouble("latitud"),obj_end.getDouble("longitud"));

                        //get values

                        history.setId(Obj_Histories.getInt("id"));

                        history.setIdWalker(Obj_Histories.getInt("ID_walker"));

                        history.setIdOwner(Obj_Histories.getInt("ID_owner"));

                        history.setStatus(Obj_Histories.getInt("status"));

                        history.setDate(Obj_Histories.getString("date"));


                        history.setStart(star);

                        history.setStart(end);

                        //add history to list

                        historials.add(history);

                    }

                }


                //adding elements

                w.setHistorial(historials);

                w.setCurrentLocation(currentLocation);

                w.setStar(route_star);

                w.setEnd(route_end);

                w.setId(Obj_Walker.getInt("id"));

                w.setName(Obj_Walker.getString("name"));

                w.setEmail(Obj_Walker.getString("email"));

                w.setCellphone(Obj_Walker.getString("cellphone"));

                w.setImage(Obj_Walker.getString("image"));

                w.setRating(Obj_Walker.getDouble("rating"));

                w.setStreet(Obj_Walker.getString("street"));

                w.setHouseNum(Obj_Walker.getInt("houseNum"));

                w.setCity(Obj_Walker.getString("city"));

                w.setCard(Obj_Walker.getString("cardNum"));

                w.setExpirMonth(Obj_Walker.getInt("expirMonth"));

                w.setExpirYear(Obj_Walker.getInt("expirYear"));

                w.setSecurityCode(Obj_Walker.getInt("secCode"));

                w.setPassword(Obj_Walker.getString("password"));

                w.setSize(Obj_Walker.getString("size"));

                w.setBreed(Obj_Walker.getString("breed"));

                w.setPlayful(Obj_Walker.getString("playful"));

                w.setDogFriendly(Obj_Walker.getString("dogFriendly"));

                w.setPeopleFriendly(Obj_Walker.getString("peopleFriendly"));

                w.setDescription(Obj_Walker.getString("description"));

                w.setGender(Obj_Walker.getString("gender"));

                w.setVaccines(Obj_Walker.getString("vaccines"));

                w.setDrooling(Obj_Walker.getString("droolingPotential"));

                w.setPriceSmall(Obj_Walker.getInt("priceSmall"));

                w.setPriceMedium(Obj_Walker.getInt("priceMedium"));

                w.setPriceBig(Obj_Walker.getInt("priceBig"));

                w.setDistance(Obj_Walker.getDouble("distance"));
                w.setTime(Obj_Walker.getDouble("time"));

                //add walker to list

                walkers.add(w);

            }


        }

        catch (JSONException e){

            Log.e("JSON Exception",e.getMessage());

        }

        catch (Exception ex){

            Log.e("General Exception",ex.getMessage());

        }

        return walkers;

    }


    @Override

    protected void onPostExecute(ArrayList<Walker> walkers){
        Log.d("Esta es la lista","Esta es la respuesta");
        ListView listViewWalker =this.activity.findViewById(R.id.lvNearWalker);
        WalkerAdapter walkerNearAdapter = new WalkerAdapter(activity, walkers);
        listViewWalker.setAdapter(walkerNearAdapter);
    }

}

