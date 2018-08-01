package me.perotin.magic_craft.events.player_events;

import me.perotin.magic_craft.MagicCraft;
import me.perotin.magic_craft.objects.Wand;
import me.perotin.magic_craft.objects.Wizard;
import me.perotin.magic_craft.objects.spells.DirectoArrowSpell;
import me.perotin.magic_craft.utils.HelperClass;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * class that handles the joining of players and the creating of wizard objects and a lot of other things I can't think of
 * at the moment.
 */
public class WizardJoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        // this code will change a lot but for
        // testing purposes
        // I am going to write this so we can make sure our system is working
        // and maybe cast a few spells or so eh?

        Player joiner = event.getPlayer();
        if(HelperClass.getWizard(joiner.getUniqueId()) == null){
            // gotta create an object for it or retrieve one, for now will just make but in the future will have to
            // retrieve it
            Wizard newWizard = new Wizard(joiner.getUniqueId(), joiner.getName());
            MagicCraft.getOnlineWizards().add(newWizard);
            newWizard.addWand(new Wand(newWizard, 10, "Phoenix core"));
            newWizard.addSpell(new DirectoArrowSpell("Directo Arrow", "Shoots an arrow in a direction", 10));
        }

    }
}
