package com.example.garbagesorting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val itemsDB: ItemsDB = ItemsDB.get()
    private val _itemsList = MutableLiveData<String>(
        itemsDB.listItems(" in ").joinToString("\n")
    )
    val itemsList: LiveData<String> get() = _itemsList
}