package com.example.garbagesorting;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class AddActivity extends AppCompatActivity {

    private static ItemsDB itemsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        itemsDB = ItemsDB.get();

        EditText whatInput = findViewById(R.id.what_text);
        EditText whereInput = findViewById(R.id.where_text);
        Button addNewButton = findViewById(R.id.addNew_button);

        addNewButton.setOnClickListener(v -> {
            String whatS = whatInput.getText().toString().trim();
            String whereS = whereInput.getText().toString().trim();
            if ((!whatS.isBlank()) && (!whereS.isBlank())) {
                if (itemsDB.search(whatS).equals("not found")) {
                    itemsDB.addItem(whatS, whereS);
                } else {
                    Toast.makeText(AddActivity.this, getString(R.string.replaced_toast, whatS), Toast.LENGTH_LONG).show();
                }
                whatInput.setText("");
                whereInput.setText("");
            } else {
                Toast.makeText(AddActivity.this, R.string.empty_toast, Toast.LENGTH_LONG).show();
            }
        });
    }
}