package com.example.hw08;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    GridView myGridView;
    int[] itemsarray = new int[]{
            R.drawable.logo_npr, R.drawable.logo_vnexpress,
            R.drawable.logo_thanhnien, R.drawable.logo_laodong,
            R.drawable.logo_tuoitre, R.drawable.logo_gamek,
            R.drawable.logo_toquoc, R.drawable.logo_danviet
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myGridView = findViewById(R.id.myGridView);
        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
                if (position==0) {
                    intent.putExtra("NAME","NPR");
                }
                else if (position==1) {
                    intent.putExtra("NAME","VNEXPRESS");
                }
                else if (position==2) {
                    intent.putExtra("NAME","THANHNIEN");
                }
                else if (position==3) {
                    intent.putExtra("NAME","LAODONG");
                }
                else if (position==4) {
                    intent.putExtra("NAME","TUOITRE");
                }
                else if (position==5) {
                    intent.putExtra("NAME","GAMEK");
                }
                else if (position==6) {
                    intent.putExtra("NAME", "TOQUOC");
                }
                else if (position==7) {
                    intent.putExtra("NAME", "DANVIET");
                }
                intent.putExtra("logo", itemsarray[position]);
                startActivity(intent);
            }
        });
        GridAdapter baseAdapter = new GridAdapter(this, itemsarray);
        myGridView.setAdapter(baseAdapter);
    }
}
