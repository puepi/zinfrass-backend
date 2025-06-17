package infra.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
public class TypeEquipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Column(nullable = false)
    private String abreviation;
    private String caracteristiques;

    @OneToMany(mappedBy = "typeEquipement")
    private List<Lot> lots=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="categorie_id",nullable = false)
    private Categorie categorie;


}
