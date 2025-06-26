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
public class Intervention {
    @EmbeddedId
    private InterventionId id;

    @Enumerated(EnumType.STRING)
    private TypeIncidentIntervention nature;

    @Enumerated(EnumType.STRING)
    private Origine raison;

    @ManyToOne
    @MapsId("equipementId")
    private Equipement equipement;

    @ManyToOne
    @MapsId("espaceId")
    private Espace espace;

    @ManyToOne
    @JoinColumn(name = "incident_id")
    private Incident incident;
    private LocalDateTime dateIntervention;
    private String nomsIntervenant;
    private String poste;
    private String diagnostic;
    private String solution;
    private String appreciation;
}
