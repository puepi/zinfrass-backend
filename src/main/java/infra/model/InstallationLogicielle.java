package infra.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class InstallationLogicielle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private String noms;
    private String poste;
    @ManyToOne
    @JoinColumn(name = "equipement_id")
    private Equipement equipement;


    @ManyToOne
    @JoinColumn(name = "logiciel_id")
    private Logiciel logiciel;

}
