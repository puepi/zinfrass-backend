package infra.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class OctroiId {
    private Long equipementId;
    private Long structureId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OctroiId that = (OctroiId) o;
        return Objects.equals(equipementId, that.equipementId) && Objects.equals(structureId, that.structureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipementId, structureId);
    }
}
