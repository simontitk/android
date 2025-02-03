package com.example.garbagesorting;

import java.util.HashMap;

public class ItemsDB {
    private final HashMap<String, String> db = new HashMap<String, String>();

    public ItemsDB() {
    }

    public void addItem(String what, String where) {
        db.put(what, where);
    }

    public String search(String what) {
        return db.getOrDefault(what, "not found");
    }

    public void fillItemsDB() {
        this.addItem("milk carton", "Food");
        this.addItem("tin can", "Metal");
        this.addItem("banana peel", "Food");
        this.addItem("50g of californium", "Radioactive Waste");
        this.addItem("water bottle", "Plastic");
        this.addItem("gamer girl bathwater bottle", "Plastic");
    }
}
