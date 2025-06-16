package infra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
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
    private int quantieStock;
    private String caracteristiques;
    private LocalDateTime dateLivraison;
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
