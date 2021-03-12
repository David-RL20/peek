package com.mancillajair.app.peek.loaders;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ListView;

import com.mancillajair.app.peek.R;
import com.mancillajair.app.peek.adapters.DogsAdapter;
import com.mancillajair.app.peek.adapters.WalkerAdapter;
import com.mancillajair.app.peek.menu.Dog;
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

public class DogsLoader extends AsyncTask<String,Void, ArrayList<Dog>> {

    private int owner;

    private Activity activity;


    public  DogsLoader(Activity activity,int owner){

        this.activity = activity;

        this.owner=owner;

    }

    @Override

    protected ArrayList<Dog> doInBackground(String... strings) {

        //create a Dogs Arraylist

        ArrayList<Dog> dogs = new ArrayList<Dog>();

        //connect to API

        InputStream data = null;

        String responseText="";

        HttpURLConnection connection = null;

        try{

            URL url = new URL("https://peek2020.000webhostapp.com/AllOwners.php?owner=1");

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

            Log.d("Response Dog", responseText);


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

            JSONArray Arr_Dogs = Obj_Owner.getJSONArray("dogs");

            if (Arr_Dogs.length() !=0){

                for (int a = 0; a <Arr_Dogs.length() ; a++) {

                    //object

                    JSONObject obj_dog = Arr_Dogs.getJSONObject(a);

                    //create a dog

                    Dog dog = new Dog();

                    dog.setId(obj_dog.getInt("id"));

                    dog.setName(obj_dog.getString("name"));

                    dog.setImage(obj_dog.getString("image"));

                    dog.setSize(obj_dog.getString("size"));

                    dog.setBreed(obj_dog.getString("breed"));

                    dog.setDescription(obj_dog.getString("description"));

                    dog.setPlayful(obj_dog.getString("playful"));

                    dog.setDogFriendly(obj_dog.getString("dogFriendly"));

                    dog.setPeopleFriendly(obj_dog.getString("peopleFriendly"));

                    dog.setGender(obj_dog.getString("gender"));

                    dog.setVaccines(obj_dog.getString("vaccines"));

                    dog.setDrooling(obj_dog.getString("droolingPotential"));

                    dog.setIdOwner(obj_dog.getInt("ID_owner"));

                    //add to list

                    dogs.add(dog);
                }
            }
        }

        catch (JSONException e){

            Log.e("JSON Exception",e.getMessage());

        }

        catch (Exception ex){

            Log.e("General Exception 2",ex.getMessage());

        }

        return dogs;

    }

    @Override

    protected void onPostExecute(ArrayList<Dog> dogs) {
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        ListView listViewWalker =this.activity.findViewById(R.id.lvDogs);
        DogsAdapter dogsAdapter = new DogsAdapter(activity, dogs);
        listViewWalker.setAdapter(dogsAdapter);
    }
}

