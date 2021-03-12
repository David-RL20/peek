package com.mancillajair.app.peek.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mancillajair.app.peek.MainActivity;
import com.mancillajair.app.peek.MainWalker;
import com.mancillajair.app.peek.R;
import com.mancillajair.app.peek.clases.Owner;
import com.mancillajair.app.peek.menu.Profile;
import com.mancillajair.app.peek.menu.Search;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ProfileOwnerAdapter  extends BaseAdapter {
    //Attributes
    private Activity activity;
    private ArrayList<Owner> listProfileOwner;
    private LayoutInflater listProfileOwnerInflater;

    public ProfileOwnerAdapter(Activity activity, ArrayList<Owner> listProfileOwner){
        this.activity = activity;
        this.listProfileOwner = listProfileOwner;
        this.listProfileOwnerInflater = (LayoutInflater) this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public ProfileOwnerAdapter(){

    }

    @Override
    public int getCount() {
        return this.listProfileOwner.size();
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
        if (view == null) view = listProfileOwnerInflater.inflate(R.layout.activity_profile, null);

        //Reference layout elements
        ImageView ivProfile = (ImageView) view.findViewById(R.id.profilePic);
        TextView tvName = (TextView) view.findViewById(R.id.tvNameTitle);
        TextView tvPhoneNumber = (TextView) view.findViewById(R.id.tvPhone);
        TextView tvLocation = (TextView) view.findViewById(R.id.tvLocation);
        TextView tvEmail = (TextView) view.findViewById(R.id.tvEmailOwner);
        TextView tvCard = (TextView) view.findViewById(R.id.tvCardOwner);


        Owner owner = this.listProfileOwner.get(i);

        ivProfile.setImageDrawable(getImage(owner.getImage()));
        tvName.setText(owner.getName());
        tvPhoneNumber.setText(owner.getCellphone());
        tvLocation.setText(owner.getStreet()+ " " + owner.getHouseNum()+ " "+ owner.getCity());
        tvEmail.setText(owner.getEmail());
        tvCard.setText(owner.getCard());

        return view;
    }
}
