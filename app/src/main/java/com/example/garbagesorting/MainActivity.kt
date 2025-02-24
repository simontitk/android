package com.example.garbagesorting

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var itemsDB: ItemsDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ItemsDB.setContext(this@MainActivity)
        itemsDB = ItemsDB.get()

        val itemInput = findViewById<EditText>(R.id.item_input)

        val whereButton = findViewById<Button>(R.id.where_button)
        whereButton.setOnClickListener { v: View? ->
            val item =
                itemInput.text.toString().trim().lowercase(Locale.getDefault())
            val placeholder = getString(R.string.placeholder_text)
            if (item.contains(placeholder)) {
                itemInput.setText("")
            } else if (!item.isBlank()) {
                itemInput.setText(
                    item + placeholder + itemsDB.search(
                        item
                    )
                )
            }
        }

        val addItem = findViewById<Button>(R.id.add_button)
        addItem.setOnClickListener { v: View? ->
            val addIntent =
                Intent(
                    this@MainActivity,
                    AddActivity::class.java
                )
            startActivity(addIntent)
        }
    }
}