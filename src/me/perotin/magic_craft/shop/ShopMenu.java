package me.perotin.magic_craft.shop;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public abstract class ShopMenu implements Listener {

   private final ArrayList<ShopItem> items;
   private final ArrayList<Inventory> pages;

    /**
     *
     * @param items in menu
     * @param firstSlot that should be used for every page
     * @param lastSlot that should be used for every page
     */
    public ShopMenu(ArrayList<ShopItem> items, int firstSlot, int lastSlot) {
        this.items = items;
        this.pages = new ArrayList<>();

    }

    public ArrayList<ShopItem> getItems() {
        return items;
    }

    public ArrayList<Inventory> getPages() {
        return pages;
    }

    /**
     * @return new blank inventory page
     */
    public abstract Inventory getNewPage();




    @EventHandler
    public abstract void onClick(InventoryClickEvent event);



    public void show(Player toShow){
        toShow.openInventory(pages.get(0));
    }
}
