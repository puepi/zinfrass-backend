package infra.model;

import infra.enums.TypeIncidentIntervention;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class  Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateIncident;
    private String nroIncident;
    private String nomsDeclarant;
    private String poste;
    private String nomStructure;
    private String resolu;
    private String objet;
    private String identifiant;
    @Enumerated(EnumType.STRING)
    private TypeIncidentIntervention type;
    @ManyToOne
    @JoinColumn(name="equipement_id")
    private Equipement equipement;

    @ManyToOne
    @JoinColumn(name="batiment_id")
    private Batiment batiment;

    @ManyToOne
    @JoinColumn(name="espace_id")
    private Espace espace;

    private String description;

    @OneToMany(mappedBy = "incident", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Intervention> interventions=new ArrayList<>();

    @OneToMany(mappedBy = "incident",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Image> images=new HashSet<>();
}
