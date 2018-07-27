package me.perotin.magic_craft.shop;

import me.perotin.magic_craft.objects.Wizard;

import java.util.ArrayList;


public class Shop  {

    private ArrayList<ShopItem> items;
    private final Wizard viewer;

    public Shop(ArrayList<ShopItem> items, Wizard viewer) {
        this.items = items;
        this.viewer = viewer;
    }

    public ArrayList<ShopItem> getItems() {
        return items;
    }

    public Wizard getViewer() {
        return viewer;
    }


}
