package infra.model;

import infra.enums.Usage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Espace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String position;
    @Enumerated(EnumType.STRING)
    private Usage usages;
    private String dimensions;

    @ManyToOne
    @JoinColumn(name="espace_id")
    private Batiment batiment;

    @ManyToOne
    @JoinColumn(name="structure_id")
    private Structure structure;

    @OneToMany(mappedBy = "espace",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Image> images=new HashSet<>();

    @OneToMany(mappedBy = "espace",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Intervention> interventions=new HashSet<>();

    @OneToMany(mappedBy = "espace")
    private Set<EspaceConnectique> espaceConnectiques=new HashSet<>();
}
