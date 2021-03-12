package com.mancillajair.app.peek.loaders;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import com.mancillajair.app.peek.R;
import com.mancillajair.app.peek.adapters.RequestOwnerAdapter;
import com.mancillajair.app.peek.adapters.WalkerAdapter;
import com.mancillajair.app.peek.clases.GeoLocation;
import com.mancillajair.app.peek.clases.Historial;
import com.mancillajair.app.peek.clases.Request;
import com.mancillajair.app.peek.clases.Walker;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class WalkerRequestLoader extends AsyncTask<String,Void, ArrayList<Request>> {
    private Activity activity;
    private int walker;

    public WalkerRequestLoader(Activity activity,int walker){
        this.activity =activity;
        this.walker= walker;
    }

    @Override
    protected ArrayList<Request> doInBackground(String... strings) {

        ArrayList<Request> requests = new ArrayList<>();


        //connect to API

        InputStream data = null;

        String responseText="";

        HttpURLConnection connection = null;

        try{

            URL url = new URL("https://peek2020.000webhostapp.com/AllRequest.php?walker="+walker);

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

            Log.d("Response Requests", responseText);

        }catch (MalformedURLException ex){

            Log.e("URL Exception",ex.getMessage());

        }catch (IOException ex){

            Log.e("IO Exception",ex.getMessage());

        }catch (Exception ex){

            Log.e("General Exception Req",ex.getMessage());

        }

        finally{

            if(connection != null) connection.disconnect();

        }

        //parse to JSON

        JSONArray request_Json = null;

        try{

            request_Json = new JSONArray(responseText);

            if(request_Json.length() != 0){
                for (int i = 0;i<request_Json.length();i++){
                    //Getting obj of request
                    JSONObject req_obj = request_Json.getJSONObject(i);
                    JSONObject owner_detail = req_obj.getJSONObject("owner_detail");
                    JSONArray dogs_array = owner_detail.getJSONArray("dogs");



                    //creating java obj
                    Request req = new Request();
                    String imgs [] = new String[dogs_array.length()];

                    req.setOwner(req_obj.getInt("owner"));
                    req.setWalker(req_obj.getInt("walker"));
                    req.setStatus(req_obj.getString("status"));
                    req.setName(owner_detail.getString("name"));
                    req.setImage(owner_detail.getString("image"));
                    req.setAddress(owner_detail.getString("houseNum")+" "+ owner_detail.getString("street") +" "+ owner_detail.getString("city"));

                    for(int j=0;j<dogs_array.length();j++){
                        JSONObject dog_obj = dogs_array.getJSONObject(j);
                        imgs[j] = dog_obj.getString("image");
                    }

                    req.setImg_dogs(imgs);

                    //add to list
                    requests.add(req);
                }
            }



        }

        catch (JSONException e){

            Log.e("JSON Exception",e.getMessage());

        }

        catch (Exception ex){

            Log.e("GE JSON Part",ex.getMessage());

        }
        //return list
        return requests;

    }


    @Override
    protected void onPostExecute(ArrayList<Request> Request){

        ListView listViewOwnerRequest =this.activity.findViewById(R.id.lvOwnerRequest);
        RequestOwnerAdapter requestOwnerAdapter = new RequestOwnerAdapter(activity, Request);
        listViewOwnerRequest.setAdapter(requestOwnerAdapter);
    }
}
