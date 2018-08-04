package me.perotin.magic_craft.objects;

import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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

    public Wand(Material type, String event, Wizard wizard, Spell spellAttached, int length, String wandCore) {
        super(type, event);
        this.wizard = wizard;
        this.spellAttached = spellAttached;
        this.length = length;
        this.wandCore = wandCore;
        setupItemStack();
    }

    public void setupItemStack(){
        ItemMeta meta = getItemMeta();
        meta.setDisplayName(spellAttached.getSpellName());
        meta.setLore(Arrays.asList(
                 wandCore, "Length: " + length
        ));
        meta.setUnbreakable(true);
        addUnsafeEnchantment(Enchantment.ARROW_DAMAGE,1);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS);
        setItemMeta(meta);
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = hash * length;
        hash = hash * wandCore.length();
        hash = hash * new Random().nextInt(100)+1;
        return hash;

    }


    public Map<String, Object> serialize(){
        Map<String, Object> serialized = new HashMap<>();
        serialized.put("hash", hashCode());
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

    public void setSpellAttached(Spell spellAttached) {
        this.spellAttached = spellAttached;
    }

    public int getLength() {
        return length;
    }

    public String getWandCore() {
        return wandCore;
    }
}
