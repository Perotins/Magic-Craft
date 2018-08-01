package me.perotin.magic_craft.objects;

import me.perotin.magic_craft.utils.HelperClass;
import me.perotin.magic_craft.utils.ItemManager;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class ManaTask extends BukkitRunnable {

    private int mana = 0;
    private final UUID uuid;

    public ManaTask(UUID uuid){
        this.uuid = uuid;
    }


    @Override
    public void run() {
        mana++;
        Wizard wizard = HelperClass.getWizard(uuid);
        if(!wizard.getWands().isEmpty()){
            for(Wand wand : wizard.getWands()){
                if(ItemManager.isSimilar(wizard.getPlayer().getInventory().getItemInMainHand(), wand)){
                    wizard.getPlayer().setExp(mana);
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
