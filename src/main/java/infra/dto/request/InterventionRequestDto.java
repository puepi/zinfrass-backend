package infra.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterventionRequestDto {
    private String nature;
    private String raison;
    private String nomsIntervenant;
    private LocalDate dateIntervention;
    private String poste;
    private String service;
    private String sur;
    private String objet;
    private String observations;
    private String identifiant;
    private String lieu;
    private String diagnostic;
    private String solution;
    private String appreciations;
}
