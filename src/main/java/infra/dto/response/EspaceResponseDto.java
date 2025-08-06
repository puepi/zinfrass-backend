package infra.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspaceResponseDto {
    private Long id;
    private String nom;
    private String position;
    private String usage;
    private String dimensions;
    private String batimentNom;
}
