package infra.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import infra.enums.TypeSubdivision;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subdivision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @EqualsAndHashCode.Include
    private Long id;
    @Column(unique = true)

    @EqualsAndHashCode.Include
    private String nom;

    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @Enumerated(EnumType.STRING)
    private TypeSubdivision type;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private Set<Subdivision> subdivisions=new HashSet<>();

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "parent_id")
    private Subdivision parent;

    @OneToMany(mappedBy = "subdivision")
    private Set<Structure> structures;
}
