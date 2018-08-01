package me.perotin.magic_craft.events.wand_events;

import me.perotin.magic_craft.MagicCraft;
import me.perotin.magic_craft.events.PlayerCastSpellEvent;
import me.perotin.magic_craft.objects.Spell;
import me.perotin.magic_craft.objects.Wand;
import me.perotin.magic_craft.objects.Wizard;
import me.perotin.magic_craft.utils.HelperClass;
import me.perotin.magic_craft.utils.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * class that checks for wand click or toggle of spell or any Magic Item
 */
public class ClickWandEvent implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Wizard wizard = HelperClass.getWizard(player.getUniqueId());
        // first checking if it was a wand
        if(!wizard.getWands().isEmpty()){
            ItemStack clicked = event.getItem();
            if(clicked != null && clicked.getType() != Material.AIR){
                for(Wand wand : wizard.getWands()){
                    if(ItemManager.isSimilar(wand, clicked)){
                       if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK){
                           // cast spell
                           Spell spell = wand.getSpellAttached();
                           if(wizard.getManaTask().getMana() >= spell.getManaCost()){
                               PlayerCastSpellEvent spellEvent = new PlayerCastSpellEvent(wizard, spell);
                               Bukkit.getPluginManager().callEvent(spellEvent);

                               if(!spellEvent.isCancelled()) {
                                   // cast it
                                   spell.cast();
                                   wizard.getPlayer().sendMessage("You casted " + spell.getSpellName());
                                   wizard.getManaTask().setMana(wizard.getManaTask().getMana() - spell.getManaCost());
                               }
                           }
                       }
                    } else if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                        // chose a different spell to cast, may make an option to use a GUI later.
                        if(!wizard.getSpells().isEmpty()){
                            int slot = 0;
                            MagicCraft.getInstance().getWizardsSelectingNewWand().put(wizard, wizard.getPlayer().getInventory());
                                for(Spell spell : wizard.getSpells()){

                                    wizard.getPlayer().getInventory().setItem(slot, spell);
                                    slot++;
                                    if(slot == 9){
                                        // ran out of slots
                                        // going to need to handle this properly at a later point
                                        // leaving empty for now
                                    }
                                }

                        }
                    }
                }
            }
        }


    }
}
