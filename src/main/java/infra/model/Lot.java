package infra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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
    private String descriptive;
    private String nomsLivreurs;
    private String techniciens;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateLivraison;
    private String observations;
    private String receptionne="Non";

    @ManyToOne
    @JoinColumn(name="type_id", nullable = false)
    private TypeEquipement typeEquipement;

    @OneToMany(mappedBy = "lot",cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    private Set<Equipement> equipements=new HashSet<>();

    @OneToMany(mappedBy = "lot",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Image> images=new HashSet<>();

    @ManyToOne
    @JoinColumn(name="provider_id")
    private Fournisseur provider;

    @OneToMany(mappedBy = "lot",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Octroi> octrois=new ArrayList<>();



//    @OneToMany(mappedBy = "lot")
//    private Set<Reception> receptions=new HashSet<>();

    public void addEquipement(Equipement equipement){
        equipements.add(equipement);
        equipement.setLot(this);
        this.quantiteStock=this.equipements.size();
    }

    // 🔑 JPA callback
    @PrePersist
    @PreUpdate
    public void updateQuantiteStock() {
        this.quantiteStock = equipements != null ? equipements.size() : 0;
    }
}
