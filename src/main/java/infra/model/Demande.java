package infra.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dateReception;
    private String objet;
    private String typeEquipement;
    private String catégorieEquipement;
    private String service;
    private String noms;
    private String poste;
//    @ManyToOne
//    @JoinColumn(name = "personnel_id")
//    private Personnel personnel;
}
