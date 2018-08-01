package me.perotin.magic_craft.objects;

import org.bukkit.Material;

public class Wand extends MagicItem {

    private final Wizard wizard;
    private Spell spellAttached;
    private final int length;
    private final String wandCore;

    public Wand(Wizard wizard, int length, String wandCore) {
        this.wizard = wizard;
        this.length = length;
        this.wandCore = wandCore;
    }

    public Wand(Material type, String event, Wizard wizard, Spell spellAttached, int length, String wandCore) {
        super(type, event);
        this.wizard = wizard;
        this.spellAttached = spellAttached;
        this.length = length;
        this.wandCore = wandCore;
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
