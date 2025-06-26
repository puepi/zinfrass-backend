package infra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nom;
    private String representant;
    private String type;
    private String adresse;
    private String contact;
    private String email;
    private String NIU;

    @OneToMany(mappedBy = "provider",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Lot> lots=new ArrayList<>();
}
