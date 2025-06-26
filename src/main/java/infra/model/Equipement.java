package infra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.events.Event;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String numeroSerie;
    private String numeroUnique;
    @ManyToOne
    @JoinColumn(name="lot_id")
    private Lot lot;

    @OneToMany(mappedBy = "equipement",cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Octroi> octrois=new ArrayList<>();

    @OneToMany(mappedBy = "equipement",fetch = FetchType.LAZY)
    private Set<InstallationLogicielle> installations = new HashSet<>();
}
