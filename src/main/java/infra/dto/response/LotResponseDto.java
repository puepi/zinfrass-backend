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
    private int quantieStock;
    private String caracteristiques;
    private LocalDateTime dateLivraison;
    private String observations;
    private String typeEquipementName;
    private List<String> equipements;
    private String providerName;
}
