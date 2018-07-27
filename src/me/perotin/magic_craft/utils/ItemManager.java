package me.perotin.magic_craft.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 * @class to handle ItemStacks and make life easier
 */
public class ItemManager {

    public static ItemStack createItem(String display,  Material type){
        ItemStack itemStack = new ItemStack(type);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(display);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack createItem(String display, Material type, String ... lores){
        ItemStack itemStack = createItem(display, type);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setLore(Arrays.asList(lores));
        itemStack.setItemMeta(meta);
        return itemStack;
    }
    public static ItemStack createItem(String display, Material type, Enchantment enchantment, boolean hide, int level, String ... lores){
        ItemStack itemStack = createItem(display, type, lores);
        ItemMeta meta = itemStack.getItemMeta();
        if(enchantment != null) {
            itemStack.addUnsafeEnchantment(enchantment, level);
            if(hide) meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }


        return itemStack;
    }


}
