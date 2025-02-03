package com.example.garbagesorting;

// we are keeping this file in case more logic is needed within the item class in future versions,
// but for now we are just using a map to store what-where pairs in the database
// this also decouples the display logic for "should be placed in" from the items


public class Item {
    private String what;
    private String where;

    public Item(String what, String where) {
        this.what = what;
        this.where = where;
    }

    @Override
    public String toString() {
        return oneLine("", "should be placed in: ");
    }

    public String getWhat() {
        return this.what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getWhere() {
        return this.where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String oneLine(String pre, String post) {
        return pre + this.what + post + this.where;
    }
}
