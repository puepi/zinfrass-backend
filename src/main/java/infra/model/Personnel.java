package infra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String noms;
    private String prenoms;
    private LocalDate dateNaissance;
//    @OneToMany(mappedBy = "personnel")
//    private List<Responsabilisation> responsabilisations;
}
