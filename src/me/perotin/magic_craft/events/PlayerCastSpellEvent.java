package me.perotin.magic_craft.events;

import me.perotin.magic_craft.objects.Spell;
import me.perotin.magic_craft.objects.Wizard;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerCastSpellEvent extends Event implements Cancellable {


    private final Wizard caster;
    private final Spell spell;
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;



    public PlayerCastSpellEvent(Wizard caster, Spell spell) {
        this.caster = caster;
        this.spell = spell;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancel = b;

    }

    public Wizard getCaster() {
        return caster;
    }

    public Spell getSpell() {
        return spell;
    }


    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}

