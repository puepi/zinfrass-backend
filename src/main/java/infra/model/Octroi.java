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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipement_id")
    private Equipement equipement;

    @ManyToOne
    @JoinColumn(name = "structure_id")
    private Structure structure;

    private LocalDateTime dateOctroi;
    private String nomsBénéficiaire;
    private String poste;
    private String referenceDocument;
}
