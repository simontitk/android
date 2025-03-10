package com.example.garbagesorting

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        val v: View = inflater.inflate(R.layout.fragment_search, container, false)
        val viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        val itemInput = v.findViewById<EditText>(R.id.item_input)

        val whereButton = v.findViewById<Button>(R.id.where_button)
        whereButton.setOnClickListener {
            activity?.let { fragmentActivity ->
                val item = itemInput.text.toString()
                val result = viewModel.searchItem(item)
                itemInput.setText(result)
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