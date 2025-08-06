package infra.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspaceRequestDto {
    private String nom;
    private String position;
    private String usage;
    private String dimensions;
    private Long batimentId;
}
