package me.perotin.magic_craft.objects;

import me.perotin.magic_craft.utils.HelperClass;
import me.perotin.magic_craft.utils.ItemManager;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

/**
 * Class for handling mana and adding mana. Have to introduce max mana at some point
 */

public class ManaTask extends BukkitRunnable {

    private int mana = 0;
    private final UUID uuid;

    public ManaTask(UUID uuid){
        this.uuid = uuid;
    }


    @Override
    public void run() {
        mana += 20;
        Wizard wizard = HelperClass.getWizard(uuid);
        if(!wizard.getWands().isEmpty()){
            for(Wand wand : wizard.getWands()){
                if(ItemManager.isSimilar(wizard.getPlayer().getInventory().getItemInMainHand(), wand)){
                    wizard.getPlayer().setLevel(mana);
                }
            }
        }
    }

    public int getMana(){
        return this.mana;
    }

    public void setMana(int mana){
        this.mana = mana;
    }
}
