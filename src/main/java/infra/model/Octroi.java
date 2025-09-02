package infra.model;

import infra.enums.Origine;
import infra.enums.TypeIncidentIntervention;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Octroi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lot_id")
    private Lot lot;


    @ManyToOne
    @JoinColumn(name = "structure_id")
    private Structure structure;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dateOctroi;
    private String nomsBénéficiaire;
    private String poste;
    private String referenceDocument;
}
