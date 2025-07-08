package infra.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
    private List<String> equipements;
    private String nomsLivreurs;
    private String providerName;
    private String caracteristiques;
}
