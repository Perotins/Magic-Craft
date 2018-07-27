package me.perotin.magic_craft.objects;

import org.bukkit.scheduler.BukkitRunnable;

public class ManaTask extends BukkitRunnable {

    private int mana = 0;

    @Override
    public void run() {
        mana++;
    }

    public int getMana(){
        return this.mana;
    }
}
