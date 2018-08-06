package me.perotin.magic_craft.objects;

import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SerializableAs("MagicItem")
public class MagicItem extends ItemStack implements ConfigurationSerializable {

    private ItemStack itemStack;
    private final String event;
    /** id to identify objects as being magicItems **/

    private final String id;

    public MagicItem() {
        super(Material.BLAZE_ROD);
        this.event = PlayerInteractEvent.class.getName();
        this.id = UUID.randomUUID().toString();
    }

    /**
     *
     * @param type
     * @param event
     * Creates a magic item with type material and event to listen for and use the use method
     */

    public MagicItem(Material type, String event, String id){
        super(type);
        this.event = event;
        this.id = id;
    }

    public MagicItem(Map<String, Object> deserial){
        this.itemStack = (ItemStack) deserial.get("itemstack");
        this.event = (String) deserial.get("event");
        this.id = (String) deserial.get("id");
    }


    public Map<String, Object> serialize(){
        Map<String, Object> serial = new HashMap<>();
        serial.put("itemstack", itemStack);
        serial.put("event", event);
        serial.put("id", id);
        return serial;
    }
    public String getId() {
        return id;
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


    /**
     * Override this method when creating a new MagicItem that can do special things and implement it
     */
    public void use(){

    }


}
