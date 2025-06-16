package infra.dto;


import infra.dto.request.TypeEquipementRequestDto;
import infra.dto.response.CategorieResponseDto;
import infra.dto.response.FournisseurResponseDto;
import infra.dto.response.LotResponseDto;
import infra.dto.response.TypeEquipementResponseDto;
import infra.model.Categorie;
import infra.model.Fournisseur;
import infra.model.Lot;
import infra.model.TypeEquipement;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.aspectj.apache.bcel.Constants.types;

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

    public static FournisseurResponseDto fournisseurToFournisseurResponseDto(Fournisseur fournisseur){
        FournisseurResponseDto responseDto=new FournisseurResponseDto();
        responseDto.setId(fournisseur.getId());
        responseDto.setNom(fournisseur.getNom());
        responseDto.setNIU(fournisseur.getNIU());
        responseDto.setContact(fournisseur.getContact());
        responseDto.setAdresse(fournisseur.getAdresse());
        responseDto.setEmail(fournisseur.getEmail());
        responseDto.setRepresentant(fournisseur.getRepresentant());
        responseDto.setType(fournisseur.getType());
        responseDto.setTechniciens(fournisseur.getTechniciens());
        Set<String> types=fournisseur.getLots()
                .stream()
                .map(lot -> lot.getTypeEquipement().getNom())
                .collect(Collectors.toSet());
        responseDto.setTypesEquipement(types);
        return responseDto;
    }

    public static LotResponseDto lotToLotResponseDto(Lot lot){
        LotResponseDto responseDto=new LotResponseDto();
        responseDto.setId(lot.getId());
        responseDto.setCouleur(lot.getCouleur());
        responseDto.setMarque(lot.getMarque());
        responseDto.setModele(lot.getModele());
        responseDto.setNroLot(lot.getNroLot());
        responseDto.setObservations(lot.getObservations());
        responseDto.setDateLivraison(lot.getDateLivraison());
        responseDto.setQuantieStock(lot.getQuantieStock());
        responseDto.setProviderName(lot.getProvider().getNom());
        responseDto.setCaracteristiques(lot.getCaracteristiques());
        responseDto.setTypeEquipementName(lot.getTypeEquipement().getNom());
        Set<String> equipements=lot.getEquipements()
                .stream()
                .map(equipement -> equipement.getNumeroUnique())
                .collect(Collectors.toSet());
        return responseDto;
    }
}
