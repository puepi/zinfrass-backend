package infra.model;

import infra.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String noms;
    private String prenoms;;
    private String matricule;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
//    @OneToMany(mappedBy = "personnel")
//    private List<Responsabilisation> responsabilisations;
}
