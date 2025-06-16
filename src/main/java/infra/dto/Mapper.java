package infra.dto;


import infra.dto.request.TypeEquipementRequestDto;
import infra.dto.response.CategorieResponseDto;
import infra.dto.response.TypeEquipementResponseDto;
import infra.model.Categorie;
import infra.model.TypeEquipement;

import java.util.List;

public class Mapper {
    public static TypeEquipementResponseDto typeEquipementToTypeEquipementResponseDto(TypeEquipement typeEquipement){
        TypeEquipementResponseDto responseDto=new TypeEquipementResponseDto();
        responseDto.setId(typeEquipement.getId());
        responseDto.setNom(typeEquipement.getNom());
        responseDto.setCaracteristiques(typeEquipement.getCaracteristiques());
        responseDto.setCategorieNom(typeEquipement.getCategorie().getNom());
        List<String> lots=typeEquipement.getLots()
                .stream()
                .map(lot -> lot.getNroLot())
                .toList();
        responseDto.setNrosLot(lots);
        return responseDto;
    }

    public static CategorieResponseDto categorieToCategorieResponseDto(Categorie categorie){
        CategorieResponseDto responseDto=new CategorieResponseDto();
        responseDto.setId(categorie.getId());
        responseDto.setNom(categorie.getNom());
        List<String> types=categorie.getTypeEquipements()
                .stream()
                .map(type -> type.getNom())
                .toList();
        responseDto.setTypesEquipement(types);
        return responseDto;
    }
}
