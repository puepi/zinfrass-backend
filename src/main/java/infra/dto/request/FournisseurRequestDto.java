package infra.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FournisseurRequestDto {
    private String nom="Inconnu";
    private String representant;
    private String techniciens;
    private String type;
    private String adresse;
    private String contact;
    private String email;
    private String NIU;
}
