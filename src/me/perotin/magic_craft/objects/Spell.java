package me.perotin.magic_craft.objects;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public abstract class Spell extends MagicItem implements Listener  {

    /** Identifier to distinguish between default and leveled spells**/
    private final String spellName;
    private final String spellDescription;
    private int manaCost;
    /** If casted wizard will not be null **/
    private Wizard wizard;

    public Spell(String spellName, String spellDescription, int manaCost) {
        this.spellName = spellName;
        this.spellDescription = spellDescription;
        this.manaCost = manaCost;
    }

    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
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

    @EventHandler
    public abstract boolean cast(PlayerInteractEvent event);



}
