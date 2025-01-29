package com.example.garbagesorting;

import java.util.ArrayList;
import java.util.List;

public class ItemsDB {
    private List<Item> ItemsDB= new ArrayList<>();

    public ItemsDB() { }

    public String listItems() {
        String r= "";
        for(Item i: ItemsDB)
            r= r+"\n Buy " + i.toString();
        return r;
    }

    // Will be used later
    public void addItem(String what, String where){
        ItemsDB.add(new Item(what, where));
    }

    public void fillItemsDB() {
        ItemsDB.add(new Item("coffee", "Irma"));
        ItemsDB.add(new Item("carrots", "Netto"));
        ItemsDB.add(new Item("milk", "Netto"));
        ItemsDB.add(new Item("bread", "bakery"));
        ItemsDB.add(new Item("butter", "Irma"));
        ItemsDB.add(new Item("gamer girl bathwater", "Hydro Homies"));
        ItemsDB.add(new Item("meat", "365"));
    }
}
