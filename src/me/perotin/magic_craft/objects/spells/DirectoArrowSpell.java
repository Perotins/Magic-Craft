package me.perotin.magic_craft.objects.spells;

import me.perotin.magic_craft.MagicCraft;
import me.perotin.magic_craft.objects.Spell;

import me.perotin.magic_craft.objects.SpellType;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * spell that sends an arrow in the direction of line of sight
 */
public class DirectoArrowSpell extends Spell {

    private float speed;

    public DirectoArrowSpell(String spellName, String spellDescription, int manaCost) {
        super(spellName, spellDescription, manaCost, SpellType.DAMAGE);
        speed = 2F;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public boolean cast() {
        sendArrow();
        return true;
    }

    // currently not sending arrow straight when facing certain directions
    private void sendArrow(){
        Player player = getWizard().getPlayer();
        Arrow arrow = player.getWorld().spawnArrow(player.getLocation().clone().add(0, .5, 1), player.getLocation().getDirection().normalize(), speed, 0F);
       new BukkitRunnable() {
          @Override
          public void run() {
              arrow.remove();
          }
      }.runTaskLater(MagicCraft.getInstance(), 20*5);

    }
}
