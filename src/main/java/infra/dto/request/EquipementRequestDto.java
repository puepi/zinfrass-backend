package infra.dto.request;

import infra.model.Lot;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipementRequestDto {
    private String numeroSerie;
    private String numeroUnique;
    private Long lotId;
}
