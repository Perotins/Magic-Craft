package me.perotin.magic_craft.objects;

import me.perotin.magic_craft.utils.HelperClass;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @apiNote
 * Class for all spells. Spell objects can be assigned to wizards after initialization or never
 * be attached to a wizard. Spells shown in shops, etc, will not have an attached wizard object
 */
@SerializableAs("MagicSpell")
public abstract class Spell extends MagicItem implements ConfigurationSerializable {

    /** Identifier to distinguish between default and leveled spells**/
    private final String spellName;
    private final String spellDescription;
    private int manaCost;
    /** If casted wizard will not be null **/
    private Wizard wizard = null;
    private final SpellType type;

    public Spell(String spellName, String id, String spellDescription, int manaCost, SpellType type) {
        super(Material.MUSIC_DISC_13, PlayerInteractEvent.class.toString(), id);
        this.spellName = spellName;
        this.spellDescription = spellDescription;
        this.manaCost = manaCost;
        this.type = type;
        setupItemStack();
    }


    /// Constructor used for deserializing objects, make sure to deserialize only when Wizard object is online or
    /// this will fail!

    /**
     *
     * @param deserializedMap for deserializing
     */
    public Spell(Map<String, Object> deserializedMap){
        this.spellName = (String) deserializedMap.get("name");
        this.spellDescription = (String) deserializedMap.get("description");
        this.manaCost = (int) deserializedMap.get("mana");
        this.type = SpellType.valueOf((String) deserializedMap.get("type"));
        this.wizard = HelperClass.getWizard(UUID.fromString((String) deserializedMap.get("wizard")));
        setupItemStack();
    }



    public SpellType getSpellType() {
        return type;
    }

    private void setupItemStack(){
        ItemMeta meta = getItemMeta();
        meta.setDisplayName(spellName);
        meta.setLore(Arrays.asList(type.toString(),
                spellDescription, "Mana Cost: " + manaCost));
    }
    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    public String getSpellName() {
        return spellName;
    }

    public String getSpellDescription() {
        return spellDescription;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    /// Wizard will not be null here because only storing spells from wizard instances
    @Override
    public Map<String, Object> serialize(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", spellName);
        map.put("description", spellDescription);
        map.put("mana", manaCost);
        map.put("type", type.toString());
        map.put("wizard", wizard.getUuid().toString());

        return map;
    }


    /**
     * @return if successful or not
     *
     * must be implemented so it can be called when registering spells
     *
     */

    @EventHandler
    public abstract boolean cast();



}
