package me.perotin.magic_craft.objects;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;

public abstract class Spell extends MagicItem implements Listener  {

    /** Identifier to distinguish between default and leveled spells**/
    private final String spellName;
    private final String spellDescription;
    private int manaCost;

    public Spell(String spellName, String spellDescription, int manaCost) {
        this.spellName = spellName;
        this.spellDescription = spellDescription;
        this.manaCost = manaCost;
    }

    public String getSpellName() {
        return spellName;
    }

    public String getSpellDescription() {
        return spellDescription;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    /**
     *
     * @param event for triggering the spell
     * @return if successful or not
     *
     * must be implemented so it can be called when registering spells
     *
     */
    public abstract boolean cast(Event event);



}
