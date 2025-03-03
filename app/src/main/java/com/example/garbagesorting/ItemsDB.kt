package com.example.garbagesorting

import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import  java.util.Observable

class ItemsDB private constructor() : Observable() {
    private val db = HashMap<String, String>()

    init {
        fillItemsDB(context!!, "items.txt")
    }

    companion object {
        private var itemsDB: ItemsDB? = null
        private var context: Context? = null

        fun setContext(context: Context) {
            ItemsDB.context = context
        }

        fun get(): ItemsDB {
            return itemsDB ?: ItemsDB().also { itemsDB = it }
        }
    }

    fun listItems(separator: String): List<String> {
        return db.entries.map { "${it.key} $separator ${it.value}" }
    }

    fun addItem(what: String, where: String) {
        db[what] = where
        setChanged()
        notifyObservers()
    }

    fun search(what: String): String {
        return db.getOrDefault(what, "not found")
    }

    private fun fillItemsDB(context: Context, fileName: String) {
        try {
            val reader = BufferedReader(InputStreamReader(context.assets.open(fileName)))
            for (line: String in reader.lines()) {
                val itemWhatWhere = line.split(", ")
                this.addItem(itemWhatWhere[0], itemWhatWhere[1])
            }
            setChanged()
            notifyObservers()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
