package com.mancillajair.app.peek.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mancillajair.app.peek.R;
import com.mancillajair.app.peek.clases.Walker;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class WalkerAdapter extends BaseAdapter {
    //Attributes
    private Activity activity;
    private ArrayList<Walker> listWalker;
    private LayoutInflater listWalkerInflater;

    //Constructor
    public WalkerAdapter(Activity activity, ArrayList<Walker> listWalker){
        this.activity = activity;
        this.listWalker = listWalker;
        this.listWalkerInflater = (LayoutInflater)this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public WalkerAdapter(){

    }

    //Methods
    @Override
    public int getCount() {
        return this.listWalker.size();
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
            if (view == null) view = listWalkerInflater.inflate(R.layout.item_near_walker, null);

        //Reference layout elements
        ImageView ivPicture = (ImageView) view.findViewById(R.id.profilePic);
        TextView tvName = (TextView) view.findViewById(R.id.tvNameTitle);
        TextView tvDistance = (TextView) view.findViewById(R.id.tvKm);
        TextView tvTime = (TextView)view.findViewById(R.id.tvTime);
        TextView tvRate = (TextView)view.findViewById(R.id.tvRatingWalk);

        Walker walk = this.listWalker.get(i);

        Double rate = walk.getPriceMedium();
        Double distance = walk.getDistance();
        Double time = walk.getTime();
        ivPicture.setImageDrawable(getImage(walk.getImage()));
        tvName.setText(walk.getName());
        tvRate.setText(rate.toString());
        tvDistance.setText(distance.toString());
        tvTime.setText(time.toString());

        return view;
    }
}
