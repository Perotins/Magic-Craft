package me.perotin.magic_craft.shop;

import me.perotin.magic_craft.objects.Wizard;

import java.util.ArrayList;

/**
 * base shop class. All shops are GUIs shown to players so they have a viewer wiz object
 */
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
