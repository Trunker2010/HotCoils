package com.example.hotcoils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

public class CoilActivity extends AppCompatActivity {
    CoilAdapter coilAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coil);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Coil.coils.add(new Coil("Fused clapton", 0.22, 100, R.drawable.fused,"Стержень: кантал 0.4 х 2.\n" + "Обмотка: нихром 0.15."));
        Coil.coils.add(new Coil("Fused clapton SS", 0.08, 100, R.drawable.fused_ss));
        Coil.coils.add(new Coil("3 Core fused clapton", 0.15, 150, R.drawable.three_core_fused));
        Coil.coils.add(new Coil("3 Core fused clapton SS", 0.08d, 150, R.drawable.three_core_fused));
        Coil.coils.add(new Coil("Staggered", 0.22, 200, R.drawable.staggered));
        Coil.coils.add(new Coil("Staggered SS", 0.08, 200, R.drawable.staggered_ss));
        Coil.coils.add(new Coil("AlienSS", 0.08, 200, R.drawable.alien_ss));
        Coil.coils.add(new Coil("Alien", 0.15, 200, R.drawable.alien_ss));
        Coil.coils.add(new Coil("3 core staggered", 0.14, 350, R.drawable.thre_core_staggered));
        Coil.coils.add(new Coil("3 core staggered SS", 0.07, 350, R.drawable.three_core_staggered_ss));
        Coil.coils.add(new Coil("Framed", 0.11, 300, R.drawable.framed));
        Coil.coils.add(new Coil("Juggernaut", 0.18, 200, R.drawable.jaggernaut));
        Coil.coils.add(new Coil("Helix", 0.18, 300, R.drawable.helix));
        Coil.coils.add(new Coil("Quadro fused clapton", 0.07, 250, R.drawable.quad_core));
        coilAdapter = new CoilAdapter(this, Coil.coils);
        ListView listView = findViewById(R.id.list_coils);
        listView.setAdapter(coilAdapter);
        listView.setOnItemClickListener(onItemClickListener);
    }

    AdapterView.OnItemClickListener onItemClickListener =
            new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            {
                Intent intent = new Intent(CoilActivity.this, CoilCategoryActivity.class);
                intent.putExtra(CoilCategoryActivity.EXTRA_COILS, position);
                startActivity(intent);
            }
        }
    };

    @Override
    protected void onDestroy() {
        Coil.coils.clear();
        super.onDestroy();
    }
}
