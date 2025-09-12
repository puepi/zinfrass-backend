package infra.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncidentResponseDto {
    private Long id;
    private LocalDate dateIncident;
    private String nroIncident;
    private String nomsDeclarant;
    private String poste;
    private String nomStructure;
    private String resolu;
    private String nature;
    private String objet;
    private String description;
    private String identifiant;
}
