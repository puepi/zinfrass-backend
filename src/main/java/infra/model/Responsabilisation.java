package infra.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Responsabilisation {
    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "structure_id")
    private Structure structure;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="poste_id")
    private Poste poste;

    private LocalDate debut;
    private LocalDate fin;
    private String nomsPrenoms;
    private boolean actif;

    @OneToOne
    @JoinColumn(name="personnel_id")
    private Personnel personnel;
}
