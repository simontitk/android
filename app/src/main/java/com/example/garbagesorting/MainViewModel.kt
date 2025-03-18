package com.example.garbagesorting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Locale

class MainViewModel : ViewModel() {
    private val itemsDB: ItemsDB = ItemsDB.get()
    private val _itemsList = MutableLiveData<String>(
        itemsDB.listItems(" in ").joinToString("\n")
    )

    fun getItemsList(): String {
        return _itemsList.value ?: "Empty list"
    }

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

    fun addItem(item: String, container: String) {
        itemsDB.addItem(item.trim().lowercase(), container.trim().lowercase())
        update()
    }

    fun deleteItem(item: String): String {
        itemsDB.removeItem(item.trim().lowercase())
        update()
        return ""
    }

    private fun update() {
        _itemsList.value = itemsDB.listItems(" in ").joinToString("\n")
    }
}