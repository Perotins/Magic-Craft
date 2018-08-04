package me.perotin.magic_craft.utils;

import me.perotin.magic_craft.MagicCraft;
import me.perotin.magic_craft.objects.Wizard;

import java.util.UUID;
import java.util.stream.Collectors;

/**
 * static class to cut down on code
 */
public class HelperClass {

    /**
     *
     * @param uuid
     * @return wizard obj or null if not found
     *
     */
    public static Wizard getWizard(UUID uuid){
        try {
            return MagicCraft.getOnlineWizards().stream().filter(wizard -> wizard.getUuid().equals(uuid)).collect(Collectors.toList()).get(0);
        } catch (IndexOutOfBoundsException ex){
            return null;
        }
    }

}
