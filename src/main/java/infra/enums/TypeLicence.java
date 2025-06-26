package infra.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeLicence {
    CRAQUEE("Craquée"),
    AUTHENTIQUE("Authentique");
    private final String label;

    TypeLicence(String label) {
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
