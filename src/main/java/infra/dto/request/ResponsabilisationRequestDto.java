package infra.dto.request;

import infra.model.Poste;
import infra.model.ResponsabilisationId;
import infra.model.Structure;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsabilisationRequestDto {
    private Long structureId;
    private Long posteId;
    private Long espaceId;
    private LocalDate debut;
    private LocalDate fin;
    private String noms;
    private Boolean actif;
}
