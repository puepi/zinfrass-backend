package infra.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatimentResponseDto {
    private Long id;
    private String nom;
    private String nature;
    private boolean isRetrocede;
    private LocalDate dateRetrocession;
    private String description;
    private String subdivisionName;
}
