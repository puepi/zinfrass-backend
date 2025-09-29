package infra.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Usage {
    TOILETTES("Toilettes"),
    BUREAU("Bureau"),
    SALLE_REUNION("Salle de réunion"),
    SECRETARIAT("Secrétariat"),
    SALLE_ATTENTE("Salle d'attente"),
    PARKING("Parking"),
    REZ_DE_CHAUSSEE("Rez de chaussée"),
    SALON("Salon"),
    SOUS_SOL("Sous-sol"),
    BIBLIOTHEQUE("Bibliothèque"),
    MAGASIN("Magasin"),
    CENTRE_ASSISTANCE("Centre d'Assistance");

    private final String label;
    Usage(String label){
        this.label=label;
    }

    public static Usage fromString(String text) {
        for (Usage type : Usage.values()) {
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
