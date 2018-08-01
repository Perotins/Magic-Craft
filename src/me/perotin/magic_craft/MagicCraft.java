package me.perotin.magic_craft;

import me.perotin.magic_craft.events.wand_events.ClickWandEvent;
import me.perotin.magic_craft.files.MyFile;
import me.perotin.magic_craft.objects.Spell;
import me.perotin.magic_craft.objects.Wizard;
import org.bukkit.Bukkit;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.HashSet;

public class MagicCraft extends JavaPlugin {

    private static HashSet<Wizard> onlineWizards;
    private static HashSet<Spell> defaultSpells;
    private static MagicCraft instance;
    private HashMap<Wizard, PlayerInventory> selectNewWand;

    @Override
    public void onEnable(){
        onlineWizards = new HashSet<>();
        defaultSpells = new HashSet<>();
        instance = this;
        this.selectNewWand = new HashMap<>();
        MyFile.loadFiles();

        Bukkit.getPluginManager().registerEvents(new ClickWandEvent(), this);
    }


    public static HashSet<Wizard> getOnlineWizards(){
        return onlineWizards;
    }

    public static HashSet<Spell> getDefaultSpells(){
        return defaultSpells;
    }

    public static MagicCraft getInstance(){
        return instance;
    }

    public HashMap<Wizard, PlayerInventory> getWizardsSelectingNewWand(){
        return selectNewWand;
    }

}
