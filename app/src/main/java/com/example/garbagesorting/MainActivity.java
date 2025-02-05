package com.example.garbagesorting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static ItemsDB itemsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsDB = ItemsDB.get();


        EditText itemInput = findViewById(R.id.item_input);

        // Main activity. Searching for items.
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

        // Intent for the add a new item button.
        Button addItem = findViewById(R.id.add_button);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add = new Intent(MainActivity.this, AddActivity.class);
                startActivity(add);
            }
        });
    }
}