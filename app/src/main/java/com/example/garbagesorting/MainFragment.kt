package com.example.garbagesorting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        if (savedInstanceState == null) {
            val transaction = childFragmentManager.beginTransaction()
            val searchFragment = SearchFragment()
            val listFragment = ListFragment()
            transaction.replace(R.id.search_fragment_container, searchFragment)
            transaction.replace(R.id.list_fragment_container, listFragment)
            transaction.commit()
        }
        return view
    }
}