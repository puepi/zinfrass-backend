package infra.dto.request;

import infra.repository.TypeEquipementRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class LotRequestDto {
    private final TypeEquipementRepository repository;
    private String nroLot;
    private String marque;
    private String modele;
    private String couleur;
    private int quantieStock;
    private String caracteristiques=repository.findByCaracteristiques();

    public LotRequestDto(TypeEquipementRepository repository) {
        this.repository = repository;
    }
}
