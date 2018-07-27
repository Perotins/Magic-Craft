package me.perotin.magic_craft.objects;

import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;


public class MagicItem extends ItemStack{

    private ItemStack itemStack;
    private Event event;

    public MagicItem() {
        super(Material.BLAZE_ROD);
        this.event = null;
    }

    /**
     *
     * @param type
     * @param event
     * Creates a magic item with type material and event to listen for and use the use method
     */
    public MagicItem(Material type, Event event){
        super(type);
        this.event = event;
    }

    /**
     * Override this method when creating a new MagicItem that can do special things and implement it
     */
    public void use(){

    }

}
