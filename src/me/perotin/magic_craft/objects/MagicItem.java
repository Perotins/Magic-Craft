package me.perotin.magic_craft.objects;

import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class MagicItem extends ItemStack{

    private ItemStack itemStack;
    private String event;

    public MagicItem() {
        super(Material.BLAZE_ROD);
        this.event = PlayerInteractEvent.class.getName();
    }

    /**
     *
     * @param type
     * @param event
     * Creates a magic item with type material and event to listen for and use the use method
     */
    public MagicItem(Material type, String event){
        super(type);
        this.event = event;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    /** returns Event that the method MagicItem#use will be called upon */
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * Override this method when creating a new MagicItem that can do special things and implement it
     */
    public void use(){

    }

}
