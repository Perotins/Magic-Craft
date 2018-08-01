package me.perotin.magic_craft.objects.spells;

import me.perotin.magic_craft.objects.Spell;
import org.bukkit.Location;
import org.bukkit.util.Vector;

/**
 * spell that sends an arrow in the direction of line of sight
 */
public class DirectoArrowSpell extends Spell {


    public DirectoArrowSpell(String spellName, String spellDescription, int manaCost) {
        super(spellName, spellDescription, manaCost);
    }



    @Override
    public boolean cast() {

        return false;
    }

    public void sendArrow(Location location){
        // double check
        getWizard().getPlayer().getLocation().getWorld().spawnArrow(getWizard().getPlayer().getLocation(), new Vector(getWizard().getPlayer().getEyeLocation().getX(), getWizard().getPlayer().getEyeLocation().getY(), getWizard().getPlayer().getEyeLocation().getZ()), 20F, 20F);
    }
}
