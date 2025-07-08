package infra.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeReseau {
    HYDROLIQUE("Hydrolique"),
    ELECTRIQUE("Electrique"),
    INFORMATIQUE("Informatique"),
    TELEPHONIQUE("Téléphonique");

    private final String label;

    TypeReseau(String label) {
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
