package com.mancillajair.app.peek.loaders;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;

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

public class WalkerLoader extends AsyncTask<String,Void, ArrayList<Walker>> {

    Activity activity;


    public WalkerLoader(Activity activity){
        this.activity = activity;
    }
    @Override
    protected ArrayList<Walker> doInBackground(String... strings) {
        ArrayList<Walker> walkers = new ArrayList<>();

        //connect to API
        InputStream data = null;
        String responseText="";
        HttpURLConnection connection = null;
        try{
            URL url = new URL("https://peek2020.000webhostapp.com/AllWalkers.php");
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
                //create a walker
                Walker w = new Walker();
                //adding elements
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
                w.setPriceSmall(Obj_Walker.getInt("priceSmall"));
                w.setPriceMedium(Obj_Walker.getInt("priceMedium"));
                w.setPriceBig(Obj_Walker.getInt("priceBig"));

                //Set time and distance
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
        //Aqui ponemos el adapter
        ListView listViewWalker =this.activity.findViewById(R.id.lvAllWalkers);
        WalkerAdapter walkerNearAdapter = new WalkerAdapter(activity, walkers);
        listViewWalker.setAdapter(walkerNearAdapter);
    }
}