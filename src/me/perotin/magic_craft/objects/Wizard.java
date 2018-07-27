package me.perotin.magic_craft.objects;

import me.perotin.magic_craft.MagicCraft;

import java.util.ArrayList;
import java.util.UUID;

public class Wizard  {

    private final UUID uuid;
    private String name;
    private ArrayList<Spell> spells;
    private ManaTask mana;

    public Wizard(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
        this.spells = new ArrayList<>();
        this.mana = new ManaTask();
        mana.runTaskTimerAsynchronously(MagicCraft.getInstance(), 0, 20*5);
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }


    /// Only used if player changes their name through Mojang's API or a plugin
    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }

    public ManaTask getMana() {
        return mana;
    }

    public void setMana(ManaTask mana) {
        this.mana = mana;
    }
}
