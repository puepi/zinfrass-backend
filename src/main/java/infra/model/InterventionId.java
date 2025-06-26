package infra.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class InterventionId implements Serializable {
    private Long equipementId;
    private Long espaceId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InterventionId that = (InterventionId) o;
        return Objects.equals(equipementId, that.equipementId) && Objects.equals(espaceId, that.espaceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipementId, espaceId);
    }
}
