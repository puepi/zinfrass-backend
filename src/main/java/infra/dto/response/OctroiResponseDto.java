package infra.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OctroiResponseDto {
    private Long id;
    private String nroLot;
    private String structure;
    private LocalDate dateOctroi;
    private String typeEquipement;
    private String marque;
    private String modele;
    private String nomsBénéficiaire;
    private String poste;
    private String referenceDocument;
}
