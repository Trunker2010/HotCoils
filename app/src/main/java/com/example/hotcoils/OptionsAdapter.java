package com.example.hotcoils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class OptionsAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Options> objects;

public OptionsAdapter (Context context, ArrayList<Options> options){
    ctx=context;
    objects =options;
    lInflater=(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
    if (view == null){
        view=lInflater.inflate(R.layout.options, parent, false);
    }
    Options options = getOption(position);

        ((TextView) view.findViewById(R.id.optionsName)).setText(options.name);
        ((ImageView)view.findViewById(R.id.optionsImage)).setImageResource(options.image);
        return view;
    }
Options getOption (int position){
    return ((Options)getItem(position));
}
}
