package com.example.garbagesorting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

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
                val result = viewModel.searchItem(itemInput.text.toString())
                itemInput.setText(result)
            }
        }

        val addFragmentButton = view.findViewById<Button>(R.id.add_fragment_button)
        addFragmentButton.setOnClickListener {
            activity?.let { fragmentActivity ->
                findNavController().navigate(R.id.action_main_to_add)
            }
        }

        val deleteButton = view.findViewById<Button>(R.id.delete_button)
        deleteButton.setOnClickListener {
            activity?.let { fragmentActivity ->
                findNavController().navigate(R.id.action_main_to_delete)
            }
        }

        return view
    }
}