package com.example.garbagesorting // we are keeping this file in case more logic is needed within the item class in future versions,
// but for now we are just using a map to store what-where pairs in the database
// this also decouples the display logic for "should be placed in" from the items


class Item(var what: String, var where: String) {
    override fun toString(): String {
        return oneLine("", "should be placed in: ")
    }

    fun oneLine(pre: String, post: String): String {
        return pre + this.what + post + this.where
    }
}
