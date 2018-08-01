package me.perotin.magic_craft.events.wand_events;

import me.perotin.magic_craft.objects.Wand;
import me.perotin.magic_craft.objects.Wizard;
import me.perotin.magic_craft.utils.HelperClass;
import me.perotin.magic_craft.utils.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

public class WandHoldEvent implements Listener {

    @EventHandler
    public void onHold(PlayerSwapHandItemsEvent event){
        Player player = event.getPlayer();
        Wizard wizard = HelperClass.getWizard(player.getUniqueId());
        ItemStack item = event.getMainHandItem();
        if(item != null || item.getType() != Material.AIR){
            if(!wizard.getWands().isEmpty()){
                for(Wand wand : wizard.getWands()){
                    if(ItemManager.isSimilar(wand, item)){
                        if(wizard.getPlayer().getExp() != wizard.getManaTask().getMana()){
                            wizard.getPlayer().setExp(wizard.getManaTask().getMana());
                        }
                    }
                }
            }
        }
    }
}
