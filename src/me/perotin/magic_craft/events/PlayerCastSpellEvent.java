package me.perotin.magic_craft.events;

import me.perotin.magic_craft.objects.Spell;
import me.perotin.magic_craft.objects.Wizard;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerCastSpellEvent extends Event {


    private final Wizard caster;
    private final Spell spell;

    public PlayerCastSpellEvent(Wizard caster, Spell spell) {
        this.caster = caster;
        this.spell = spell;
    }

    public Wizard getCaster() {
        return caster;
    }

    public Spell getSpell() {
        return spell;
    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }
}
