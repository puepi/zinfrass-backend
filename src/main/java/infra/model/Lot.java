package infra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int quantieStock;
    private String caracteristiques;

    @ManyToOne
    @JoinColumn(name="type_id", nullable = false)
    private TypeEquipement typeEquipement;

    @OneToMany(mappedBy = "lot",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Equipement> equipements;
}
