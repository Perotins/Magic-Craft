package me.perotin.magic_craft.shop;


import me.perotin.magic_craft.utils.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

/**
 * Class for showing shops. Might need some rethinking about adding a Shop field
 */
public abstract class ShopMenu implements Listener {

   private final ArrayList<ShopItem> items;
   private final ArrayList<Inventory> pages;
   private int firstSlot, lastSlot, pageNumber;
   private final int size;
   private final String identifier;
   private final ItemStack goBack, goForward;

    /**
     *
     * @param items in menu
     * @param firstSlot that should be used for every page
     * @param lastSlot that should be used for every page
     * page number is +1 number of index
     */
    public ShopMenu(ArrayList<ShopItem> items, int firstSlot, int lastSlot, int size, String identifier) {
        this.items = items;
        this.pages = new ArrayList<>();
        this.pageNumber = 1;
        this.firstSlot = firstSlot;
        this.lastSlot = lastSlot;
        this.size = size;
        this.identifier = identifier;
        this.goBack = ItemManager.createItem("&3Previous page", Material.SIGN);
        this.goForward = ItemManager.createItem("&3Next Page", Material.SIGN);


    }

    public ItemStack getGoBack() {
        return goBack;
    }

    public ItemStack getGoForward() {
        return goForward;
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getSize() {
        return size;
    }

    public int getFirstSlot() {
        return firstSlot;
    }



    public int getLastSlot() {
        return lastSlot;
    }


    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public ArrayList<ShopItem> getItems() {
        return items;
    }

    public ArrayList<Inventory> getPages() {
        return pages;
    }

    /**
     * @param page number
     * @return new blank inventory page
     */
    public abstract Inventory getNewPage(int page);


    /**
     * @param viewer of inventory
     */
    public abstract void showPage(Player viewer);


    @EventHandler
    public abstract void onClick(InventoryClickEvent event);



    public void show(Player toShow){
        toShow.openInventory(pages.get(0));
    }
}
