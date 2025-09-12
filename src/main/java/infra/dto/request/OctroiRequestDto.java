package infra.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OctroiRequestDto {
    private Long lotId;
    private Long structureId;
    private LocalDate dateOctroi;
    private String nomsBénéficiaire;
    private String poste;
    private String referenceDocument;
}
