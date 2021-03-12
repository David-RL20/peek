package com.mancillajair.app.peek.loaders;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.mancillajair.app.peek.clases.Walker;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OneWalkerLoader extends AsyncTask<String,Void, Walker> {

    private Activity activity;
    private int id;

    public OneWalkerLoader(Activity activity , int walker){
        this.activity = activity;
        this.id = walker;
    }
    @Override
    protected Walker doInBackground(String... strings) {
        Walker _walker = new Walker(1);

        //connect to API
        InputStream data = null;
        String responseText = "";
        HttpURLConnection connection = null;
        try {
            URL url = new URL("https://peek2020.000webhostapp.com/AllWalkers.php?walker=" + this.id);
            connection = (HttpURLConnection) url.openConnection();
            Log.d("Connection", "Successfully established connection");

            data = connection.getInputStream();// get data
            StringBuilder rawData = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(data));

            //read lines
            String dataline = "";
            while ((dataline = reader.readLine()) != null) {
                rawData.append(dataline);//add text to string builder

            }

            responseText = rawData.toString();
            Log.d("Response One Walker", responseText);

        } catch (MalformedURLException ex) {
            Log.e("URL Exception", ex.getMessage());
        } catch (IOException ex) {
            Log.e("IO Exception", ex.getMessage());
        } catch (Exception ex) {
            Log.e("General Exception", ex.getMessage());
        } finally {
            if (connection != null) connection.disconnect();
        }
        //parse to JSON
        JSONObject Obj_Walker = null;
        try {
            Obj_Walker = new JSONObject(responseText);

            //adding elements
            _walker.setId(Obj_Walker.getInt("id"));
            _walker.setName(Obj_Walker.getString("name"));
            _walker.setEmail(Obj_Walker.getString("email"));
            _walker.setCellphone(Obj_Walker.getString("cellphone"));
            _walker.setImage(Obj_Walker.getString("image"));
            _walker.setRating(Obj_Walker.getDouble("rating"));
            _walker.setStreet(Obj_Walker.getString("street"));
            _walker.setHouseNum(Obj_Walker.getInt("houseNum"));
            _walker.setCity(Obj_Walker.getString("city"));
            _walker.setCard(Obj_Walker.getString("cardNum"));
            _walker.setExpirMonth(Obj_Walker.getInt("expirMonth"));
            _walker.setExpirYear(Obj_Walker.getInt("expirYear"));
            _walker.setSecurityCode(Obj_Walker.getInt("secCode"));
            _walker.setPassword(Obj_Walker.getString("password"));
            _walker.setPriceSmall(Obj_Walker.getInt("priceSmall"));
            _walker.setPriceMedium(Obj_Walker.getInt("priceMedium"));
            _walker.setPriceBig(Obj_Walker.getInt("priceBig"));

            //Set time and distance
            _walker.setDistance(Obj_Walker.getDouble("distance"));
            _walker.setTime(Obj_Walker.getDouble("time"));


        } catch (JSONException e) {
            Log.e("JSON Exception", e.getMessage());
        } catch (Exception ex) {
            Log.e("GE oneWalker", ex.getMessage());
        }
        return _walker;
    }

    @Override
    protected void onPostExecute(Walker walker) {
        super.onPostExecute(walker);
        Toast.makeText(this.activity.getApplicationContext(),"Nombre:"+walker.getName(),Toast.LENGTH_LONG).show();
    }
}
