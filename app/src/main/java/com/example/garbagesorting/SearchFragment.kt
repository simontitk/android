package com.example.garbagesorting

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import java.util.Locale


class SearchFragment : Fragment() {
    private lateinit var itemsDB: ItemsDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = requireContext()
        ItemsDB.setContext(context)
        itemsDB = ItemsDB.get()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v: View = inflater.inflate(R.layout.fragment_search, container, false)

        val itemInput = v.findViewById<EditText>(R.id.item_input)

        val whereButton = v.findViewById<Button>(R.id.where_button)
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

        val addItem = v.findViewById<Button>(R.id.add_button)
        addItem.setOnClickListener { v: View? ->
            val context = requireContext()
            val addIntent =
                Intent(
                    context,
                    AddActivity::class.java
                )
            startActivity(addIntent)
        }
        return v
    }
}