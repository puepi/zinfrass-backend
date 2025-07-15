package infra.dto.request;

import infra.model.Espace;
import infra.model.FacturesEauElec;
import infra.model.Subdivision;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
