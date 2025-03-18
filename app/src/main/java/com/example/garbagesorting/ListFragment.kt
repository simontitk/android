package com.example.garbagesorting

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class ListFragment : Fragment() {
    // private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        val itemsList = view.findViewById<TextView>(R.id.items_list)
        itemsList.movementMethod = ScrollingMovementMethod()
        itemsList.text = viewModel.getItemsList()
        return view
    }
}
