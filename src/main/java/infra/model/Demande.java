package infra.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateReception;
    private String objet;
    private String typeEquipement;
    private String catégorieEquipement;
    @ManyToOne
    @JoinColumn(name = "personnel_id")
    private Personnel personnel;
}
