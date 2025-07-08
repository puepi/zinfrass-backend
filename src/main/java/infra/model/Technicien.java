package infra.model;

import infra.enums.PersonelStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Technicien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String noms;
    private String poste;
    @Enumerated(EnumType.STRING)
    private PersonelStatus status;

    @OneToMany(mappedBy = "technicien")
    private Set<Reception> receptions=new HashSet<>();

    @OneToMany(mappedBy = "technicien")
    private Set<Intervention> interventions=new HashSet<>();
}
