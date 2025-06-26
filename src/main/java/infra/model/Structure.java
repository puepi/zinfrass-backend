package infra.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import infra.enums.TypeStructure;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Structure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false,unique = true)
    @EqualsAndHashCode.Include
    private String nom;

    @Column(nullable = false,unique = true)
    @EqualsAndHashCode.Include
    private String abreviation;

    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @Enumerated(EnumType.STRING)
    private TypeStructure type;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="sub_id")
    private Subdivision subdivision;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private Set<Structure> structures=new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "parent_id")
    private Structure parent;

    @OneToMany(mappedBy = "structure",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Responsabilisation> occupations=new ArrayList<>();

    @OneToMany(mappedBy = "structure",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Espace> espaces=new ArrayList<>();

    @OneToMany(mappedBy = "structure",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Octroi> octrois=new ArrayList<>();
}
