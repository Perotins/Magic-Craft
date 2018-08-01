package me.perotin.magic_craft.objects.spells;

import me.perotin.magic_craft.objects.Spell;

import org.bukkit.entity.Player;

/**
 * spell that sends an arrow in the direction of line of sight
 */
public class DirectoArrowSpell extends Spell {


    public DirectoArrowSpell(String spellName, String spellDescription, int manaCost) {
        super(spellName, spellDescription, manaCost);
    }



    @Override
    public boolean cast() {
        sendArrow();
        return true;
    }

    public void sendArrow(){
        // double check
        Player player = getWizard().getPlayer();
        player.getWorld().spawnArrow(player.getLocation(), player.getLocation().getDirection().multiply(2), 10F, 1F);

    }
}
