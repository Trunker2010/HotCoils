package com.example.hotcoils;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class CoilCategoryActivity extends AppCompatActivity {
    public static final String EXTRA_COILS = "Coil_id";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coli_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        int coilID = (Integer) getIntent().getExtras().get(EXTRA_COILS);
        Coil coil = Coil.coils.get(coilID);
        ((TextView)findViewById(R.id.coilName)).setText(coil.getName());
        ((ImageView)findViewById(R.id.bigImage)).setImageResource(coil.getImageResourceId());
        ((TextView)findViewById(R.id.coilPrice)).setText(coil.getPrice()+"\u20BD");
        ((TextView)findViewById(R.id.coilMaterial)).setText(coil.getMaterial());
        ((TextView) findViewById(R.id.coilOhm)).setText( String.valueOf(coil.getResistance()+"Ω"));
        if (coil.getResistance() < 0.1) {
            ((TextView) findViewById(R.id.coilOhm)).setTextColor(getResources().getColor(R.color.hot));
        } else
            ((TextView) findViewById(R.id.coilOhm)).setTextColor(getResources().getColor(R.color.nohot));
    }


}
