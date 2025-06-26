package infra.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Rang {
    MINISTRE("Ministre"),
    SECRETAIRE_GENERAL("Secrétaire Général"),
    SECRETAIRE_GENERAL_ADJOINT("Secrétaire Général Adjoint"),
    INSPECTEUR_GENERAL("Inspecteur Général"),
    DIRECTEUR("Directeur"),
    DIRECTEUR_ADJOINT("Directeur Adjoint"),
    SOUS_DIRECTEUR("Sous-Directeur"),
    CHEF_SERVICE("Chef de Service"),
    CHEF_SERVICE_ADJOINT("Chef de Service Adjoint"),
    CHEF_BUREAU("Chef de Bureau");

    private final String label;
    Rang(String label) {
        this.label = label;
    }

    public static Rang fromString(String text) {
        for (Rang type : Rang.values()) {
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
