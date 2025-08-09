package infra.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LotResponseDto {
    private Long id;
    private String nroLot;
    private String marque;
    private String modele;
    private String couleur;
    private int quantiteStock;
    private String descriptive;
    private String typeEquipementName;
    private Set<String> equipements;
    private String nomsLivreurs;
    private String techniciens;
    private LocalDate dateReception;
    private String  observations;
    private String providerName;
    private String caracteristiques;
}
