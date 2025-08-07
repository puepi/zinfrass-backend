package infra.dto.request;

import infra.model.Fournisseur;
import infra.model.TypeEquipement;
import infra.repository.TypeEquipementRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class LotRequestDto {
    private String nroLot;
    private String marque;
    private String modele;
    private String couleur;
    private int quantiteStock;
    private String descriptive;
    private Long typeEquipementId;
    private List<EquipementRequestDto> equipements;
    private String nomsLivreurs;
    private String techniciens;
    private LocalDate dateReception;
    private String  observations;
    private Long providerId;
    private String caracteristiques;
}
