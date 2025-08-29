package infra.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonnelResponseDto {
    private Long id;
    private String noms;
    private String prenoms;;
    private String matricule;
}
