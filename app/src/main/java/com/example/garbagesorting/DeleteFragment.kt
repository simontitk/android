package com.example.garbagesorting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class DeleteFragment : Fragment() {
    // private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_delete, container, false)
        val viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        val deleteInput = view.findViewById<EditText>(R.id.delete_input)

        val deleteButton = view.findViewById<Button>(R.id.delete_button)
        deleteButton.setOnClickListener {
            activity?.let { fragmentActivity ->
                val result = viewModel.deleteItem(deleteInput.text.toString())
                deleteInput.setText(result)
            }
        }

        return view
    }
}