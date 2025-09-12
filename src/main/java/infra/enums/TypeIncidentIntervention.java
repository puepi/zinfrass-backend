package infra.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeIncidentIntervention {
    MATERIEL_STOCK("Materiel en stock"),
    MATERIEL_OCTROYE("Materiel octroyé"),
    LOGICIEL("Logiciel"),
    BATIMENT("Bâtiment"),
    ESPACE("Espace");
    private final String label;

    TypeIncidentIntervention(String label) {
        this.label = label;
    }

    public static TypeIncidentIntervention fromString(String text) {
        for (TypeIncidentIntervention type : TypeIncidentIntervention.values()) {
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
