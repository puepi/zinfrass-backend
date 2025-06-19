package infra.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeSubdivision {
    CENTRAUX("Services Centraux"),
    REGION("Région"),
    DEPARTEMENT("Département"),
    ARRONDISSEMENT("Arrondissement");

    private final String label;

    TypeSubdivision(String label) {
        this.label = label;
    }

    public static TypeSubdivision fromString(String text) {
        for (TypeSubdivision type : TypeSubdivision.values()) {
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
