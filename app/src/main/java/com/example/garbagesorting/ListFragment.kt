package com.example.garbagesorting

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.Observable
import java.util.Observer

class ListFragment : Fragment(), Observer {
    private lateinit var itemsDB: ItemsDB
    private lateinit var itemsList: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = requireContext()
        ItemsDB.setContext(context)
        itemsDB = ItemsDB.get()
        itemsDB.addObserver(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v: View = inflater.inflate(R.layout.fragment_list, container, false)
        itemsList = v.findViewById<TextView>(R.id.items_list)
        itemsList.movementMethod = ScrollingMovementMethod()
        addItems()
        return v
    }

    private fun addItems() {
        itemsList.text = ""
        itemsDB.listItems("in")
            .forEach {
                itemsList.append(it + "\n")
            }
    }

    @Deprecated("Deprecated in Java")
    override fun update(o: Observable?, arg: Any?) {
        addItems()
    }
}