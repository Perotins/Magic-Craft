package me.perotin.magic_craft.events.wand_events;

import me.perotin.magic_craft.objects.Wand;
import me.perotin.magic_craft.objects.Wizard;
import me.perotin.magic_craft.utils.HelperClass;
import me.perotin.magic_craft.utils.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

public class WandHoldEvent implements Listener {

    @EventHandler
    public void onHold(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        Wizard wizard = HelperClass.getWizard(player.getUniqueId());
        ItemStack item = player.getInventory().getItem(event.getNewSlot());
        ItemStack oldItem = player.getInventory().getItem(event.getPreviousSlot());
        Bukkit.broadcastMessage(item.getItemMeta().getDisplayName() + " "+oldItem.getType().toString());
        if (!wizard.getWands().isEmpty()) {
            for (Wand wand : wizard.getWands()) {
                if (ItemManager.isSimilar(wand, item)) {
                    Bukkit.broadcastMessage("1");
                    if (wizard.getPlayer().getExp() != wizard.getManaTask().getMana()) {
                        wizard.getPlayer().setExp(wizard.getManaTask().getMana());
                    }
                } else if (ItemManager.isSimilar(wand, oldItem)) {
                    Bukkit.broadcastMessage("2");

                    wizard.getPlayer().setExp(0);
                }
            }
        }
    }
}
