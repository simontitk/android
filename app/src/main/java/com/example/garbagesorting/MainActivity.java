package com.example.garbagesorting;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ItemsDB itemsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsDB = new ItemsDB();
        itemsDB.fillItemsDB();

        EditText itemInput = findViewById(R.id.item_input);

        Button whereButton = findViewById(R.id.where_button);
        whereButton.setOnClickListener(v -> {
            String item = itemInput.getText().toString().strip();
            String placeholder = getString(R.string.placeholder_text);
            if (item.contains(placeholder)) {
                itemInput.setText("");
            } else if (!item.isBlank()) {
                itemInput.setText(item + placeholder + this.itemsDB.search(item));
            }
        });
    }
}