package com.example.garbagesorting;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ItemsDB {
    private static ItemsDB itemsDB;
    private static Context context;
    private final HashMap<String, String> db = new HashMap<String, String>();

    private ItemsDB() {
        if (context == null) {
            throw new IllegalStateException("context must be set first");
        }
        fillItemsDB(context, "items.txt");
    }

    public static void setContext(Context context) {
        ItemsDB.context = context;
    }

    public static ItemsDB get() {
        if (itemsDB == null) itemsDB = new ItemsDB();
        return itemsDB;
    }

    public void addItem(String what, String where) {
        db.put(what, where);
    }

    public String search(String what) {
        return db.getOrDefault(what, "not found");
    }

    private void fillItemsDB(Context context, String fileName) {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(fileName)));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] itemWhatWhere = line.split(", ");
                this.addItem(itemWhatWhere[0], itemWhatWhere[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
