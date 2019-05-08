package com.example.hotcoils;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CoilAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Coil> objects;
    TextView textView;

    public CoilAdapter(Context context, ArrayList<Coil> coils) {
        ctx = context;
        objects = coils;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view==null){
            view = lInflater.inflate(R.layout.coils_list, parent, false);
        }
        textView = view.findViewById(R.id.coilOhm);
        Coil coil= getCoil(position);
        ((TextView)view.findViewById(R.id.coilName)).setText(coil.getName());
        ((TextView)view.findViewById(R.id.coilOhm)).setText("~"+coil.getResistance()+" Ω");
        ((TextView)view.findViewById(R.id.coilPrice)).setText(coil.getPrice()+"\u20BD");
        ((ImageView)view.findViewById(R.id.coilImage)).setImageResource(coil.getImageResourceId());

        if (coil.getResistance()<0.1d){
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.hot));
        }
        else {

            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.nohot));
        }

        return view;
    }

    Coil getCoil(int position){
        return ((Coil)getItem(position));
    }
}
