package com.mancillajair.app.peek.loaders;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mancillajair.app.peek.R;
import com.mancillajair.app.peek.clases.GeoLocation;
import com.mancillajair.app.peek.clases.Historial;
import com.mancillajair.app.peek.menu.Dog;
import com.mancillajair.app.peek.clases.Owner;

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
import java.util.zip.Inflater;

public class OwnerLoader extends AsyncTask<String,Void, Owner> {

    Activity activity;
    private LayoutInflater listProfileOwnerInflater;

    public OwnerLoader(Activity activity){
        this.activity = activity;
        this.listProfileOwnerInflater = (LayoutInflater) this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    protected Owner doInBackground(String... strings) {
        //create a walker
        Owner ow = new Owner();
        //connect to API
        InputStream data = null;
        String responseText="";
        HttpURLConnection connection = null;
        try{
            URL url = new URL("https://peek2020.000webhostapp.com/AllOwners.php?owner=3");
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
            Log.d("Response Owner", responseText);

        }catch (MalformedURLException ex){
            Log.e("URL Exception",ex.getMessage());
        }catch (IOException ex){
            Log.e("IO Exception",ex.getMessage());
        }catch (Exception ex){
            Log.e("General Exception 1",ex.getMessage());
        }
        finally{
            if(connection != null) connection.disconnect();
        }

        try{    //get objects within objects
            JSONObject Obj_Owner = new JSONObject(responseText);

            //adding elements
            ow.setId(Obj_Owner.getInt("id"));
            ow.setName(Obj_Owner.getString("name"));
            ow.setEmail(Obj_Owner.getString("email"));
            ow.setCellphone(Obj_Owner.getString("cellphone"));
            ow.setImage(Obj_Owner.getString("image"));
            ow.setRating(Obj_Owner.getDouble("rating"));
            ow.setStreet(Obj_Owner.getString("street"));
            ow.setHouseNum(Obj_Owner.getString("houseNum"));
            ow.setCity(Obj_Owner.getString("city"));
            ow.setCard(Obj_Owner.getString("cardNum"));
            ow.setExpirMonth(Obj_Owner.getInt("expirMonth"));
            ow.setExpirYear(Obj_Owner.getInt("expirYear"));
            ow.setSecurityCode(Obj_Owner.getInt("secCode"));
            ow.setPassword(Obj_Owner.getString("password"));

        }
        catch (JSONException e){
            Log.e("JSON Exception",e.getMessage());
        }
        catch (Exception ex){
            Log.e("General Exception 2",ex.getMessage());
        }

        return ow;
    }

    public static Drawable getImage(String url)
    {
        Drawable d = null;
        try
        {
            InputStream is = (InputStream) new URL(url).getContent();
            d = Drawable.createFromStream(is, url);
            return d;
        }
        catch (MalformedURLException e) { }
        catch (IOException e) { }
        return d;
    }

    @Override
    protected void onPostExecute(Owner owner){
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        //Reference layout elements

        ImageView ivProfile = (ImageView) this.activity.findViewById(R.id.profilePic);
        TextView tvName = (TextView) this.activity.findViewById(R.id.tvNameTitle);
        TextView tvPhoneNumber = (TextView) this.activity.findViewById(R.id.tvPhone);
        TextView tvLocation = (TextView) this.activity.findViewById(R.id.tvLocationDogWalker);
        TextView tvEmail = (TextView) this.activity.findViewById(R.id.tvEmailOwner);
        TextView tvCard = (TextView) this.activity.findViewById(R.id.tvCardOwner);

        ivProfile.setImageDrawable(getImage(owner.getImage()));
        tvName.setText(owner.getName());
        tvPhoneNumber.setText(owner.getCellphone());
        tvLocation.setText(owner.getStreet() + " " + owner.getCity());
        tvEmail.setText(owner.getEmail());
        tvCard.setText(owner.getCard());
    }
}
