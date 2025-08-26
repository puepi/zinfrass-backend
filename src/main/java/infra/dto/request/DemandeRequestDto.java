package infra.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeRequestDto {
    private LocalDate dateReception;
    private String objet;
    private String typeEquipement;
    private String catégorieEquipement;
    private String service;
    private String noms;
}
