package com.example.garbagesorting

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        itemsDB = ItemsDB.get()

        val whatInput = findViewById<EditText>(R.id.what_text)
        val whereInput = findViewById<EditText>(R.id.where_text)
        val addNewButton = findViewById<Button>(R.id.addNew_button)

        addNewButton.setOnClickListener { v: View? ->
            val whatS = whatInput.text.toString().trim { it <= ' ' }
            val whereS = whereInput.text.toString().trim { it <= ' ' }
            if ((!whatS.isBlank()) && (!whereS.isBlank())) {
                if (itemsDB!!.search(whatS) != "not found") {
                    Toast.makeText(
                        this@AddActivity,
                        getString(R.string.replaced_toast, whatS),
                        Toast.LENGTH_LONG
                    ).show()
                }
                itemsDB!!.addItem(
                    whatS,
                    whereS
                )
                whatInput.setText("")
                whereInput.setText("")
            } else {
                Toast.makeText(
                    this@AddActivity,
                    R.string.empty_toast,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    companion object {
        private var itemsDB: ItemsDB? = null
    }
}