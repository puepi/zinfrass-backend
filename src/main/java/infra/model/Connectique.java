package infra.model;

import infra.enums.TypeReseau;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Connectique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nature;
    @Enumerated(EnumType.STRING)
    private TypeReseau typeReseau;

    @OneToMany(mappedBy = "connectique")
    private Set<EspaceConnectique> espaceConnectiques=new HashSet<>();
}
