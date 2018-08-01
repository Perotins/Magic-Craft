package me.perotin.magic_craft.objects;

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
