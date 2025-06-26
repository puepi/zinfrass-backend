package infra.model;

import infra.enums.Origine;
import infra.enums.TypeIncidentIntervention;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Octroi {
    @EmbeddedId
    private OctroiId id;

    @ManyToOne
    @MapsId("equipementId")
    private Equipement equipement;

    @ManyToOne
    @MapsId("structureId")
    private Structure structure;

    private LocalDateTime dateOctroi;
    private String nomsBénéficiaire;
    private String poste;
    private String referenceDocument;
}
