package infra.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeStructure {
    CABINET_MINISTRE("Cabinet du Ministre"),
    SECRETARIAT_GENERALE("Secrétariat Général"),
    INSPECTION_GENERALE("Inspection Générale"),
    DIRECTION("Direction"),
    SOUS_DIRECTION("Sous-direction"),
    DIVISION("Division"),
    CELLULE("Cellule"),
    SERVICE("Service"),
    BUREAU("Bureau"),
    DELEGATION_ARRONDISSEMENT("Délégation d'Arrondissement"),
    DELEGATION_DEPARTEMENTALE("Délégation Départementale"),
    DELEGATION_REGIONALE("Délégation Régionale"),
    CRECHE_HALTE_GARDERIE("Crèche et Halte Garderie"),
    CENTRE_PROMOTION_FEMME_FAMILLE("Centre de Promotion de la Femme et de la Famille"),
    CENTRE_TECHNOLOGIES_APPROPRIE("Centre de Technologies Approprié");

    private final String label;

    TypeStructure(String label) {
        this.label = label;
    }

    public static TypeStructure fromString(String text) {
        for (TypeStructure type : TypeStructure.values()) {
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
