package com.example.garbagesorting

import androidx.lifecycle.ViewModel
import java.util.Locale

class MainViewModel : ViewModel() {
    private val itemsDB: ItemsDB = ItemsDB.get()


    fun searchItem(item: String): String {
        val itemCleaned = item.trim().lowercase(Locale.getDefault())
        val placeholder = " should be placed in "
        if (itemCleaned.contains(placeholder)) {
            return ""
        } else if (itemCleaned.isNotBlank()) {
            return itemCleaned + placeholder + itemsDB.search(itemCleaned)
        } else {
            return ""
        }
    }

    fun removeItem() {

    }

}

