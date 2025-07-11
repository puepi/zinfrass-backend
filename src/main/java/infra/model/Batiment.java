package infra.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Batiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nom;
    private String nature;
    private boolean isRetrocede;
    private LocalDate dateRetrocession;
    @OneToMany(mappedBy = "batiment")
    private List<FacturesEauElec> facturesEauElec=new ArrayList<>();

    @OneToMany(mappedBy = "batiment")
    private List<Espace> espaces=new ArrayList<>();

    @OneToMany(mappedBy = "batiment")
    private List<Intervention> interventions=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="subdivision_id")
    private Subdivision subdivision;
}
