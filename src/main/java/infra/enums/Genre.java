package infra.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Genre {
    FEMININ("féminin"),
    MASCULIN("masculin");

    private final String label;

    Genre(String label) {
        this.label = label;
    }

    public static Genre fromString(String text) {
        for (Genre type : Genre.values()) {
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
}
