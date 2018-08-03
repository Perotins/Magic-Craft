package me.perotin.magic_craft.objects;

import me.perotin.magic_craft.MagicCraft;
import me.perotin.magic_craft.files.MyFile;
import me.perotin.magic_craft.shop.ShopMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class Wizard  {

    private final UUID uuid;
    private String name;
    private ArrayList<Spell> spells;
    private ManaTask mana;
    private ShopMenu menu = null;
    private ArrayList<Wand> wands;


    public Wizard(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
        this.spells = new ArrayList<>();
        this.mana = new ManaTask(uuid);
        mana.runTaskTimerAsynchronously(MagicCraft.getInstance(), 0, 20*2);
        this.wands = new ArrayList<>();


    }


    public ArrayList<Wand> getWands() {
        return wands;
    }

    public void addWand(Wand wand){
        wands.add(wand);
        getPlayer().getInventory().addItem(wand);
    }

    public ShopMenu getMenu() {
        return menu;
    }

    public Player getPlayer(){
        return Bukkit.getPlayer(uuid);
    }

    public void writeToFile(){
        // going to need to rewrite this once spells and wands are serializable
        MyFile yml = new MyFile(MyFile.wizardData);
        yml.set(uuid.toString()+".name", name);
        yml.set(uuid.toString()+".spells", spells);
        yml.set(uuid.toString()+".mana", mana);
        yml.set(uuid.toString()+".wands", wands);

    }

    public void setMenu(ShopMenu menu) {
        this.menu = menu;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void addSpell(Spell spell){
        spells.add(spell);
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

    public ManaTask getManaTask() {
        return mana;
    }

    public void setMana(ManaTask mana) {
        this.mana = mana;
    }
}
