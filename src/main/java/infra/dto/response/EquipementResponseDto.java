package infra.dto.response;

import infra.model.Lot;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipementResponseDto {
    private Long id;
    private String numeroSerie;
    private String numeroUnique;
    private String nroLot;
    private String currentPosition;
    private String lieu;
    private Long lastLotId;
}
