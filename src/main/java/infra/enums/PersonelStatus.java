package infra.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PersonelStatus {
    MINPROFF("Minproff"),
        EXTERNE("Externe");
    private final String label;

    PersonelStatus(String label) {
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
