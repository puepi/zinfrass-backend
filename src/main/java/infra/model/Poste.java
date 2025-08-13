package infra.model;

import infra.enums.Rang;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String nom;
    private String abreviation;
    @Enumerated(value = EnumType.STRING)
    private Rang rang;


    @OneToMany(mappedBy = "poste")
    private List<Responsabilisation> occupations=new ArrayList<>();
}
