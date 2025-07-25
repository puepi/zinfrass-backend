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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeIncidentIntervention nature;

    @Enumerated(EnumType.STRING)
    private Origine raison;

    @ManyToOne
    @JoinColumn(name="technicien_id")
    private Technicien technicien;

    @ManyToOne
    @JoinColumn(name="equipement_id")
    private Equipement equipement;

    @ManyToOne
    @JoinColumn(name="batiment_id")
    private Batiment batiment;

    @ManyToOne
    @JoinColumn(name="espace_id")
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
