package com.example.garbagesorting;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class AddActivity extends AppCompatActivity {

    private static ItemsDB itemsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        itemsDB = ItemsDB.get();

        TextView newWhat = findViewById(R.id.what_text);
        TextView newWhere = findViewById(R.id.where_text);

        Button addItem = findViewById(R.id.addNew_button);
        // adding a new thing
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String whatS = newWhat.getText().toString().trim();
                String whereS = newWhere.getText().toString().trim();
                if ((whatS.length() > 0) && (whereS.length() > 0)) {
                    itemsDB.addItem(whatS, whereS);
                    newWhat.setText("");
                    newWhere.setText("");
                } else
                    Toast.makeText(AddActivity.this, R.string.empty_toast, Toast.LENGTH_LONG).show();
            }
        });

    }

}