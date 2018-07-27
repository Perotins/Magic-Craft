package me.perotin.magic_craft;

import me.perotin.magic_craft.files.MyFile;
import me.perotin.magic_craft.objects.Spell;
import me.perotin.magic_craft.objects.Wizard;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;

public class MagicCraft extends JavaPlugin {

    private static HashSet<Wizard> onlineWizards;
    private static HashSet<Spell> defaultSpells;
    private static MagicCraft instance;

    @Override
    public void onEnable(){
        onlineWizards = new HashSet<>();
        defaultSpells = new HashSet<>();
        instance = this;
        MyFile.loadFiles();
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

}
