package me.perotin.magic_craft.shop.menus;


import me.perotin.magic_craft.objects.Wizard;
import me.perotin.magic_craft.shop.ShopItem;
import me.perotin.magic_craft.shop.ShopMenu;
import me.perotin.magic_craft.utils.HelperClass;
import me.perotin.magic_craft.utils.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

/**
 * Class for showing spells. Not essential but will be worked on later
 */

public class DefaultSpellMenu extends ShopMenu {

    public DefaultSpellMenu(ArrayList<ShopItem> items, int first, int last, int size){
        super(items, first, last, size, "DefaultSpellMenu");
    }


    @Override
    public Inventory getNewPage(int page) {
        return Bukkit.createInventory(null, 63, "First level spells P. "+page);
    }


    /**

     * @param viewer of inventory
     *  Going to need to make more robust at a later point
     */
    @Override
    public void showPage(Player viewer) {
        Inventory blankPage = getNewPage(getPageNumber());
        int slot = getFirstSlot();
        for(ShopItem shopItem : getItems()){
            if(blankPage.getItem(getLastSlot()) != null){
                // page is full
                getPages().add(blankPage);
                blankPage = getNewPage(getPageNumber()+1);
                slot = getFirstSlot();
                blankPage.setItem(slot, shopItem.getItem());
                slot++;
            }
            blankPage.setItem(slot, shopItem.getItem());
            slot++;
        }
        if(!getPages().contains(blankPage)) getPages().add(blankPage);
        viewer.openInventory(getPages().get(0));


    }

    // Need to implement currency / buying but for now going to exclude that till we figure out what we want to do
    @Override
    public void onClick(InventoryClickEvent event) {
        if(event.getWhoClicked() instanceof Player){
            Player clicker = (Player) event.getWhoClicked();
            Wizard wizard = HelperClass.getWizard(event.getWhoClicked().getUniqueId());
            if(wizard.getMenu() != null){
                ShopMenu shopMenu = wizard.getMenu();
                if(shopMenu.getIdentifier().equals(getIdentifier())){
                    // same menu object
                    DefaultSpellMenu menu = (DefaultSpellMenu) wizard.getMenu();
                    ItemStack clicked = event.getCurrentItem();
                    if (clicked != null && clicked.getType() != Material.AIR && clicked.hasItemMeta()) {
                        event.setCancelled(true);
                        if(ItemManager.isSimilar(menu.getGoBack(), clicked)){
                            // go back a page
                            if(menu.getPageNumber() > 1 && getPages().size() > 1) {
                                menu.setPageNumber(menu.getPageNumber() - 1);
                                clicker.openInventory(menu.getPages().get(menu.getPageNumber() - 1));
                            }
                        } else if(ItemManager.isSimilar(menu.getGoForward(), clicked)){
                            if(menu.getPages().size() > 1 && menu.getPageNumber() < menu.getPages().size()+1){
                                // go forward a page
                                clicker.openInventory(menu.getPages().get(getPageNumber()));
                                menu.setPageNumber(menu.getPageNumber()+1);

                            }

                        } else {
                            for (ShopItem shopItem : getItems()) {
                                if(ItemManager.isSimilar(shopItem.getItem(), clicked)){
                                    // buying this item
                                    // implement a system for this later
                                    clicker.getInventory().addItem(shopItem.getItem());
                                    break;
                                }
                            }
                        }

                    }


                }
            }
        }

    }
}
