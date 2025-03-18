package com.example.garbagesorting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class SearchFragment : Fragment() {
    // private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_search, container, false)
        val viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        val itemInput = view.findViewById<EditText>(R.id.item_input)
        val whereButton = view.findViewById<Button>(R.id.where_button)
        whereButton.setOnClickListener {
            activity?.let { fragmentActivity ->
                val item = itemInput.text.toString()
                val result = viewModel.searchItem(item)
                itemInput.setText(result)
            }
        }
        return view
    }
}