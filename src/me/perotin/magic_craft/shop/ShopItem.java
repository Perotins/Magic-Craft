package me.perotin.magic_craft.shop;

import me.perotin.magic_craft.objects.MagicItem;
import me.perotin.magic_craft.objects.Spell;
import org.bukkit.Material;
import org.bukkit.event.Event;

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

    public ShopItem(int cost, Spell spell, Material type, Event event){
        super(type, event);
        this.spell = spell;
        this.cost = cost;


    }
}
