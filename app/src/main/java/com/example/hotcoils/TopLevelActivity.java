package com.example.hotcoils;

import android.content.Intent;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class TopLevelActivity extends AppCompatActivity {

    OptionsAdapter optionsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        ArrayList<Options> options = new ArrayList<>();
        options.add(new Options("Coils",R.drawable.coil));
        options.add(new Options("Service",R.drawable.servise));
        options.add(new Options("Contacts",R.drawable.baseline_location_on_black_48dp));
        optionsAdapter = new OptionsAdapter(this,options);
        ListView listView = findViewById(R.id.list_options);
        listView.setAdapter(optionsAdapter);
        listView.setOnItemClickListener(onItemClickListener);


    }
    private ListView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position==0){
                Intent intent  = new Intent(TopLevelActivity.this, CoilActivity.class);
                startActivity(intent);
            }
            if (position==2){
                Intent intent  = new Intent(TopLevelActivity.this, Contacts_activity.class);
                startActivity(intent);
            }
        }
    };

}
