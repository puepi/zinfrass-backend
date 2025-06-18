package infra.model;

import infra.enums.TypeFacture;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class FacturesEauElec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeFacture type;
    private String numeroFacture;
    private String numéroCompteur;
    private LocalDate debut;
    private LocalDate fin;
    private BigDecimal consommation;
    private Long ancienIndex;
    private Long nouvelIndex;
    private String unites;
    @ManyToOne
    @JoinColumn(name="batiment_id")
    private Batiment batiment;
}
