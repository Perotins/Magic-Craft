package me.perotin.magic_craft.shop;

import me.perotin.magic_craft.objects.MagicItem;
import me.perotin.magic_craft.objects.Spell;
import org.bukkit.Material;

public class ShopItem extends MagicItem {

    /// Null if it isn't a spell being sold
    private Spell spell;
    private final int cost;

    public ShopItem(int cost) {
        this.cost = cost;
    }

    public ShopItem(int cost, Spell spell) {
        this(cost);
        this.spell = spell;
    }

    public ShopItem(int cost, Spell spell, Material type, String event){
        super(type, event.getClass().toString());
        this.spell = spell;
        this.cost = cost;


    }
}
