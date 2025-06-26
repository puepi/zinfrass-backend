package infra.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Responsabilisation {
    @EmbeddedId
    private ResponsabilisationId id;

    @ManyToOne
    @MapsId("structureId")
    private Structure structure;

    @ManyToOne
    @MapsId("posteId")
    private Poste poste;

    private LocalDate debut;
    private LocalDate fin;
    private String noms;
    private boolean actif;
}
