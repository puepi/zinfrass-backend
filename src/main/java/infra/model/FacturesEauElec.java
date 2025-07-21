package infra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import infra.enums.TypeFacture;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Blob;
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
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate debut;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fin;
    private BigDecimal consommation;
    private BigDecimal montant;
    private Long ancienIndex;

    private Long nouvelIndex;
    private String unites="mètres cube (m3)";

    @ManyToOne
    @JoinColumn(name="batiment_id")
    private Batiment batiment;
}
