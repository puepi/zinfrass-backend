package infra.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Responsabilisation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "structure_id")
    private Structure structure;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="poste_id")
    private Poste poste;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate debut;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate fin;
    private String nomsPrenoms;
    private Boolean actif=false;

//    @OneToOne
//    @JoinColumn(name="personnel_id")
//    private Personnel personnel;
}
