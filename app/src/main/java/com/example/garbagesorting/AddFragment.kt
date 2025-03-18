package com.example.garbagesorting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class AddFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_add, container, false)
        val viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        val newItemInput = view.findViewById<EditText>(R.id.new_item_input)
        val newContainerInput = view.findViewById<EditText>(R.id.new_container_input)
        val addItemButton = view.findViewById<Button>(R.id.add_button)
        addItemButton.setOnClickListener {
            activity?.let { fragmentActivity ->
                viewModel.addItem(newItemInput.text.toString(), newContainerInput.text.toString())
                newItemInput.setText("")
                newContainerInput.setText("")
            }
        }

        return view
    }
}