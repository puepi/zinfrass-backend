package infra.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeLogiciel {
    SYSTEME_EXPLOITATION("Système d'exploitation"),
    SUITE_BUREAUTIQUE("Suite bureautique"),
    APPLICATIONS("Applications"),
    ANTIVIRUS("Antivirus");
    private final String label;

    TypeLogiciel(String label) {
        this.label = label;
    }
    public static TypeLogiciel fromString(String text) {
        for (TypeLogiciel type : TypeLogiciel.values()) {
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
