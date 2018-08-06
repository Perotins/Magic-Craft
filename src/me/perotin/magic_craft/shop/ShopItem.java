package me.perotin.magic_craft.shop;

import me.perotin.magic_craft.objects.Spell;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class ShopItem implements ConfigurationSerializable {

    /// Null if it isn't a spell being sold
    private Spell spell;
    private final int cost;
    private ItemStack item;

    public ShopItem(int cost) {
        this.cost = cost;
    }

    public ShopItem(int cost, Spell spell) {
        this(cost);
        this.spell = spell;
    }


    /**
     *
     * @param cost of item
     * @param spell null if not a spell
     * @param item itemstack of item
     */
    public ShopItem(int cost, Spell spell, ItemStack item){
        this.spell = spell;
        this.cost = cost;
        this.item = item;

    }

    public ShopItem(Map<String, Object> map){
        if(map.keySet().contains("spell")){
            this.spell = (Spell) map.get("spell");
        }
        this.cost = (int) map.get("cost");
        this.item = (ItemStack) map.get("itemstack");
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> serial = new HashMap<>();
        if(spell != null) {
            serial.put("spell", spell);
        }
        serial.put("cost", cost);
        serial.put("itemstack", item);
        return serial;
    }

    /**
     * @return Spell or null if it is not a spell
     */
    public Spell getSpell() {
        return spell;
    }

    public int getCost() {
        return cost;
    }

    public ItemStack getItem() {
        return item;
    }
}
