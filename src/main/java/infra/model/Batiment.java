package infra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateRetrocession;
    private String description;
    @Column(unique=true)
    private String numeroUnique;
    @OneToMany(mappedBy = "batiment")
    private List<FacturesEauElec> facturesEauElec=new ArrayList<>();

    @OneToMany(mappedBy = "batiment")
    private List<Espace> espaces=new ArrayList<>();

    @OneToMany(mappedBy = "batiment")
    private List<Intervention> interventions=new ArrayList<>();

    @OneToMany(mappedBy = "batiment",fetch = FetchType.LAZY)
    private Set<Incident> incidents = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="subdivision_id")
    private Subdivision subdivision;
}
