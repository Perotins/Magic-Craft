package me.perotin.magic_craft.objects;

/**
 * Type of spell, not a totally useful class but might have some use later
 */
public enum  SpellType {

    DAMAGE("Damage"), MOVEMENT("Movement"), BUILDING ("Building"), UTILITY ("Utility");

    private final String text;

    /**
     * @param text
     */
    SpellType(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
