package com.mancillajair.app.peek.adapters;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mancillajair.app.peek.R;
import com.mancillajair.app.peek.menu.Dog;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class DogsAdapter extends BaseAdapter {

    private Activity activity;

    private ArrayList<Dog> dogs;

    private LayoutInflater listWalkerInflater;

    public DogsAdapter(Activity ac ,ArrayList<Dog> dogs){

        this.activity =ac;

        this.dogs = dogs;

        this.listWalkerInflater = (LayoutInflater)this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override

    public int getCount() {

        return this.dogs.size();

    }


    @Override

    public Object getItem(int i) {

        return i;

    }

    @Override

    public long getItemId(int i) {

        return i;

    }

    @Override

    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) view = listWalkerInflater.inflate(R.layout.item_dog, null);

        //conseguir los elementos de xml
        ImageView ivDogProfile = (ImageView) view.findViewById(R.id.ivDogProfile);
        TextView tvDogName = (TextView) view.findViewById(R.id.tvDogName);
        TextView tvDogBreed = (TextView) view.findViewById(R.id.tvBreed);
        TextView tvSize = (TextView) view.findViewById(R.id.tvSize);
        CheckBox cbIsPlayful = (CheckBox) view.findViewById(R.id.checkBoxIsPlayful);
        CheckBox cbIsWellBehaved = (CheckBox) view.findViewById(R.id.checkBoxIsFriendly);
        CheckBox cbIsPeopleFriendly = (CheckBox) view.findViewById(R.id.checkBoxIsPeopleFriendly);
        CheckBox cbVaccines = (CheckBox) view.findViewById(R.id.checkBoxVaccines);

        //asignar la informacion
        ivDogProfile.setImageDrawable(getImage(dogs.get(i).getImage()));
        tvDogName.setText(dogs.get(i).getName());
        tvDogBreed.setText(dogs.get(i).getBreed());
        tvSize.setText(dogs.get(i).getSize());
//      Toast.makeText(view.getContext(), "Playful " + dogs.get(i).getPlayful() , Toast.LENGTH_LONG).show();

        if (dogs.get(i).getPlayful().equals("yes")){
            cbIsPlayful.setChecked(true);
        }
        if (dogs.get(i).getDogFriendly().equals("yes")){
            cbIsWellBehaved.setChecked(true);
        }
        if (dogs.get(i).getPeopleFriendly().equals("yes")){
            cbIsPeopleFriendly.setChecked(true);
        }
        if (dogs.get(i).getVaccines().equals("yes")){
            cbVaccines.setChecked(true);
        }

        return view;
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

}

