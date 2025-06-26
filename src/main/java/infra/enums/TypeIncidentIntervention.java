package infra.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeIncidentIntervention {
    MATERIEL("Materiel"),
    LOGICIEL("Logiciel"),
    BATIMENT("Bâtiment"),
    ESPACE("Espace");
    private final String label;

    TypeIncidentIntervention(String label) {
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
