package infra.dto.request;

import infra.model.Fournisseur;
import infra.model.TypeEquipement;
import infra.repository.TypeEquipementRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LotRequestDto {
    private String nroLot;
    private String marque;
    private String modele;
    private String couleur;
    private int quantiteStock;
    private String caracteristiques;
    private String descriptive;
    private String nomsLivreurs;
    private Long typeEquipementId;
    private Long providerId;
}
