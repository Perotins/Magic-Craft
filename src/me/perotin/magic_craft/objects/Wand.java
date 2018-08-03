package me.perotin.magic_craft.objects;

import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Wand extends MagicItem implements ConfigurationSerializable {

    private final transient Wizard wizard;
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
