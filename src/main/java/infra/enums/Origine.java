package infra.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Origine {
    INSTALLATION("Installation"),
    RECEPTION("Réception"),
    MAINTENANCE("Maintenance"),
    DEPANNAGE("Dépannage"),
    DEPLACEMENT("Déplacement");

    private final String label;

    Origine(String label) {
        this.label = label;
    }
    public static Origine fromString(String text) {
        for (Origine type : Origine.values()) {
            if (type.label.equalsIgnoreCase(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant for value: " + text);
    }

    @JsonValue // Ensures correct serialization in JSON responses
    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
