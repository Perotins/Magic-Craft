package me.perotin.magic_craft;

import me.perotin.magic_craft.events.player_events.WizardJoinEvent;
import me.perotin.magic_craft.events.wand_events.ClickWandEvent;
import me.perotin.magic_craft.events.wand_events.WandHoldEvent;
import me.perotin.magic_craft.objects.Spell;
import me.perotin.magic_craft.objects.Wand;
import me.perotin.magic_craft.objects.Wizard;
import me.perotin.magic_craft.objects.spells.DirectoArrowSpell;
import me.perotin.magic_craft.utils.HelperClass;
import org.bukkit.Bukkit;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.HashSet;


/**
 * @author Perotin
 * started on July 24th, 2018
 */
public class MagicCraft extends JavaPlugin {

    /*
    TODO list of stuff I will do once we start implementing
    1. Implement join event to retrieve player objects from file
    2. Implement shop system or buy system or something
    http://www.kammerl.de/ascii/AsciiSignature.php
     */

    /*
    TODO short term stuff to do next
    1. Make Wand, and Spell class fully implement ConfigurationSeriazable.
            good resource -> https://www.spigotmc.org/threads/tutorial-bukkit-custom-serialization.148781/

     */

    private static HashSet<Wizard> onlineWizards;
    private static HashSet<Spell> defaultSpells;
    private static MagicCraft instance;
    private HashMap<Wizard, PlayerInventory> selectNewWand;

    static {
        ConfigurationSerialization.registerClass(Spell.class, "Spell");
        ConfigurationSerialization.registerClass(Spell.class, "Wand");
        ConfigurationSerialization.registerClass(Spell.class, "MagicItem");
        ConfigurationSerialization.registerClass(Spell.class, "Spell");

    }
    @Override
    public void onEnable(){
        onlineWizards = new HashSet<>();
        defaultSpells = new HashSet<>();
        instance = this;
        this.selectNewWand = new HashMap<>();
        saveDefaultConfig();
        //MyFile.loadFiles();

        Bukkit.getPluginManager().registerEvents(new ClickWandEvent(), this);
        Bukkit.getPluginManager().registerEvents(new WandHoldEvent(), this);
        Bukkit.getPluginManager().registerEvents(new WizardJoinEvent(this), this);
        test();

    }

    private void test(){
        for(Player joiner : Bukkit.getOnlinePlayers()) {
            if (HelperClass.getWizard(joiner.getUniqueId()) == null) {
                // gotta create an object for it or retrieve one, for now will just make but in the future will have to
                // retrieve it
                Wizard newWizard = new Wizard(joiner.getUniqueId(), joiner.getName());
                MagicCraft.getOnlineWizards().add(newWizard);
                Wand wand = new Wand(newWizard, 10, "Phoenix core test");
                DirectoArrowSpell spell = new DirectoArrowSpell("Directo Arrow", "Shoots an arrow in a direction", 10);
                spell.setWizard(newWizard);
                newWizard.addSpell(spell);
                wand.setSpellAttached(spell);
                newWizard.addWand(wand);

            }
        }
    }


    public static HashSet<Wizard> getOnlineWizards(){
        return onlineWizards;
    }

    public static HashSet<Spell> getDefaultSpells(){
        return defaultSpells;
    }

    public static MagicCraft getInstance(){
        return instance;
    }

    public HashMap<Wizard, PlayerInventory> getWizardsSelectingNewWand(){
        return selectNewWand;
    }

}
