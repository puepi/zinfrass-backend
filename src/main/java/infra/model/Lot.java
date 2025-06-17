package infra.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nroLot;
    private String marque;
    private String modele;
    private String couleur;
    @Column(nullable = false)
    private int quantiteStock;
    private String caracteristiques;
    private LocalDateTime dateLivraison;
    private String nomsTechnciens;
    private String nomsLivreurs;
    private String observations;

    @ManyToOne
    @JoinColumn(name="type_id", nullable = false)
    private TypeEquipement typeEquipement;

    @OneToMany(mappedBy = "lot",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Equipement> equipements=new HashSet<>();

    @ManyToOne
    @JoinColumn(name="provider_id")
    private Fournisseur provider;

    public void setTypeEquipement(TypeEquipement typeEquipement) {
        this.typeEquipement = typeEquipement;
        if(typeEquipement!=null)
            this.caracteristiques=typeEquipement.getCaracteristiques();
    }
}
