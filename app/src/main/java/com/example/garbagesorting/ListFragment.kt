package com.example.garbagesorting

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {
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
        val v: View = inflater.inflate(R.layout.fragment_list, container, false)
        val itemsList = v.findViewById<TextView>(R.id.items_list)
        itemsList.movementMethod = ScrollingMovementMethod()

        itemsDB.listItems("in")
            .forEach {
                itemsList.append(it + "\n")
            }

        return v
    }
}