package infra.model;

import infra.enums.TypeIncidentIntervention;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateIncident;
    private String declarant;
    private String poste;
    @Enumerated(EnumType.STRING)
    private TypeIncidentIntervention type;
    private Long objet;
    private String description;
    private String propostion;
    @OneToMany(mappedBy = "incident", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Intervention> interventions=new ArrayList<>();

    @OneToMany(mappedBy = "incident",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Image> images=new HashSet<>();
}
