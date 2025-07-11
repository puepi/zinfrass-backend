package infra.dto.response;

import infra.model.Responsabilisation;
import infra.model.ResponsabilisationId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsabilisationResponseDto {
    private ResponsabilisationId id;
    private String nomStructure;
    private String nomPoste;
    private LocalDate debut;
    private LocalDate fin;
    private String noms;
    private boolean actif;
}
