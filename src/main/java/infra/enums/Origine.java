package infra.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Origine {
    INSTALLATION("Installation"),
    MAINTENANCE("Maintenance"),
    DEPLACEMENT("Déplacement");

    private final String label;

    Origine(String label) {
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
