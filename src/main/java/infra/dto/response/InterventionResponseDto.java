package infra.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterventionResponseDto {
    private Long id;
    private String nature;
    private String raison;
    private String nomsIntervenant;
    private LocalDate dateIntervention;
    private String poste;
    private String service;
    private String objet;
    private String identifiant;
    private String lieu;
    private String diagnostic;
    private String solution;
    private String appreciations;
}
