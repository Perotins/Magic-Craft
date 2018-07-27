package me.perotin.magic_craft.files;

import me.perotin.magic_craft.MagicCraft;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MyFile extends YamlConfiguration {

    public static File wizardData = new File(MagicCraft.getInstance().getDataFolder(), "wizards.yml");
    public static File messageData = new File(MagicCraft.getInstance().getDataFolder(), "messages.yml");

    private File file;

    public MyFile(File file) {
        this.file = file;
        try {
            load(file);
        } catch (IOException | InvalidConfigurationException e2){
            e2.printStackTrace();
        }
    }

    public static void loadFiles(){
        MagicCraft.getInstance().saveResource("wizards.yml", false);
        MagicCraft.getInstance().saveResource("messages.yml", false);

    }


}
