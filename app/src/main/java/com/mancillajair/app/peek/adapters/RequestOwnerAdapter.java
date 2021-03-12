package com.mancillajair.app.peek.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mancillajair.app.peek.R;
import com.mancillajair.app.peek.clases.Owner;
import com.mancillajair.app.peek.clases.Request;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class RequestOwnerAdapter extends BaseAdapter {
    //Attributes
    private Activity activity;
    private ArrayList<Request> listOwner;
    private LayoutInflater listOwnerInflater;

    //Constructor
    public RequestOwnerAdapter(Activity activity, ArrayList<Request> listOwner){
        this.activity = activity;
        this.listOwner = listOwner;
        this.listOwnerInflater = (LayoutInflater)this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listOwner.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) view = listOwnerInflater.inflate(R.layout.item_owner_request, null);

        //Reference form XML
        ImageView ivProfileOwner = (ImageView) view.findViewById(R.id.ivProfileOwner);
        TextView tvTittleName = (TextView) view.findViewById(R.id.tvTittleNameOwner);
        TextView tvAddress = (TextView) view.findViewById(R.id.tvAddressOwner);
        //No hay descripcion en el API prro
        TextView tvDescription = (TextView) view.findViewById(R.id.tvDescriptionOwner);
        ImageView tvDogOwner1 = (ImageView) view.findViewById(R.id.ivDogOwner1);
        ImageView tvDogOwner2 = (ImageView) view.findViewById(R.id.ivDogOwner2);
        ImageView tvDogOwner3 = (ImageView) view.findViewById(R.id.ivDogOwner3);

        Request request = this.listOwner.get(i);

        ivProfileOwner.setImageDrawable(getImage(request.getImage()));
        tvTittleName.setText(request.getName());
        tvAddress.setText(request.getAddress());
//        tvDescription.setText(request.getDescription());
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        //Salio error por eso estan comentadas

        if(request.getImg_dogs().length > 0){
            String[] imgs = request.getImg_dogs();
            switch (request.getImg_dogs().length){
                case 1:
                    tvDogOwner1.setImageDrawable(getImage(imgs[0]));
                    break;
                case 2:
                    tvDogOwner1.setImageDrawable(getImage(imgs[0]));
                    tvDogOwner2.setImageDrawable(getImage(imgs[1]));
                    break;
                case 3:
                    tvDogOwner1.setImageDrawable(getImage(imgs[0]));
                    tvDogOwner2.setImageDrawable(getImage(imgs[1]));
                    tvDogOwner3.setImageDrawable(getImage(imgs[2]));
                    break;
            }


        }


        return view;
    }
}
