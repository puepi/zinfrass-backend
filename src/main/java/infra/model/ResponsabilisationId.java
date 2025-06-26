package infra.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponsabilisationId implements Serializable {
    private Long structureId;
    private Long posteId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ResponsabilisationId that = (ResponsabilisationId) o;
        return Objects.equals(structureId, that.structureId) && Objects.equals(posteId, that.posteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(structureId, posteId);
    }
}
