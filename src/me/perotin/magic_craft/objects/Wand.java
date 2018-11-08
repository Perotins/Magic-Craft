package me.perotin.magic_craft.objects;

import me.perotin.magic_craft.utils.HelperClass;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

/**
 * Object for every wand. Wands have some attributes like wand core and length which are cosmetics.
 * Every wand must have a wizard with it and spell attached is null at initialization
 */
@SerializableAs("MagicWand")
public class Wand extends MagicItem implements ConfigurationSerializable {

    private final Wizard wizard;
    private Spell spellAttached;
    private final int length;
    private final String wandCore;

    public Wand(Wizard wizard, int length, String wandCore) {
        this.wizard = wizard;
        this.length = length;
        this.wandCore = wandCore;
        setupItemStack();
    }

    public Wand(Material type, String event, String id, Wizard wizard, Spell spellAttached, int length, String wandCore) {
        super(type, event, id);
        this.wizard = wizard;
        this.spellAttached = spellAttached;
        this.length = length;
        this.wandCore = wandCore;
        setupItemStack();
    }

    public Wand(Map<String, Object> map){
        this.wizard = HelperClass.getWizard(UUID.fromString((String) map.get("wizard")));
        this.wandCore = (String) map.get("wandcore");
        this.length = (int) map.get("length");
        this.spellAttached = wizard.getSpell((String) map.get("attached_spell"));
    }

    private void setupItemStack(){
        ItemMeta meta = getItemMeta();
        if(spellAttached == null) meta.setDisplayName(ChatColor.DARK_AQUA+"Current Spell: None");
        else meta.setDisplayName(spellAttached.getSpellName());
        meta.setLore(Arrays.asList(
                 wandCore, "Length: " + length
        ));
        meta.setUnbreakable(true);
        addUnsafeEnchantment(Enchantment.ARROW_DAMAGE,1);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS);
        setItemMeta(meta);
    }




    public Map<String, Object> serialize(){
        Map<String, Object> serialized = new HashMap<>();
        serialized.put("wizard", wizard.getUuid().toString());
        serialized.put("wandcore", wandCore);
        serialized.put("length", length);
        serialized.put("attached_spell", spellAttached.toString());



        return serialized;

    }

    public Wizard getWizard() {
        return wizard;
    }

    public Spell getSpellAttached() {
        return spellAttached;
    }

    /**
     *
     * @param spellAttached sets the current spell for wand and resets ItemMeta of wand
     */
    public void setSpellAttached(Spell spellAttached) {
        this.spellAttached = spellAttached;
        setupItemStack();
    }

    public int getLength() {
        return length;
    }

    public String getWandCore() {
        return wandCore;
    }
}
