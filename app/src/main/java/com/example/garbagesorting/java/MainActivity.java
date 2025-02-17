package com.example.garbagesorting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static ItemsDB itemsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ItemsDB.setContext(MainActivity.this);
        itemsDB = ItemsDB.get();

        EditText itemInput = findViewById(R.id.item_input);

        Button whereButton = findViewById(R.id.where_button);
        whereButton.setOnClickListener(v -> {
            String item = itemInput.getText().toString().strip().toLowerCase();
            String placeholder = getString(R.string.placeholder_text);
            if (item.contains(placeholder)) {
                itemInput.setText("");
            } else if (!item.isBlank()) {
                itemInput.setText(item + placeholder + itemsDB.search(item));
            }
        });

        Button addItem = findViewById(R.id.add_button);
        addItem.setOnClickListener(v -> {
            Intent addIntent = new Intent(MainActivity.this, AddActivity.class);
            startActivity(addIntent);
        });
    }
}