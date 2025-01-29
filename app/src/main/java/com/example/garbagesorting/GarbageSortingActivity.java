package com.example.garbagesorting;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GarbageSortingActivity extends AppCompatActivity {

    // Model: Database of items
    private ItemsDB itemsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.garbage);

        itemsDB= new ItemsDB();
        itemsDB.fillItemsDB();

        TextView items= findViewById(R.id.items);

        Button listItems= findViewById(R.id.list_button);
        listItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.setBackgroundColor(Color.parseColor("#FFFFFF"));
                items.setText("Shopping List:"+"\n"+itemsDB.listItems());
            }
        });
    }
    }