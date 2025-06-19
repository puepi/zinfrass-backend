package infra.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeFacture {
    EAU("Eau"),
    ELECTRICITE("Electricité");
    private final String label;

    TypeFacture(String label) {
        this.label = label;
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
