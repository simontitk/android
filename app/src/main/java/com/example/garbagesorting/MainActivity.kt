package com.example.garbagesorting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    private lateinit var itemsDB: ItemsDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ItemsDB.setContext(this@MainActivity)
        itemsDB = ItemsDB.get()

        var fm: FragmentManager = supportFragmentManager
        val fragment_search = fm.findFragmentById(R.id.search_container)
        val fragment_list = fm.findFragmentById(R.id.list_container)

        if (fragment_search == null && fragment_list == null) {
            fm.beginTransaction()
                .add(R.id.search_container, SearchFragment())
                .commit()
            fm.beginTransaction()
                .add(R.id.list_container, ListFragment())
                .commit()
        }
    }


}