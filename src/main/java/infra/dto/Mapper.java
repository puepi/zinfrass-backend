package infra.dto;


import infra.dto.response.*;
import infra.model.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Mapper {
    public static TypeEquipementResponseDto typeEquipementToTypeEquipementResponseDto(TypeEquipement typeEquipement){
        TypeEquipementResponseDto responseDto=new TypeEquipementResponseDto();
        responseDto.setId(typeEquipement.getId());
        responseDto.setNom(typeEquipement.getNom());
        responseDto.setCaracteristiques(typeEquipement.getCaracteristiques());
        responseDto.setCategorieNom(typeEquipement.getCategorie().getNom());
        responseDto.setAbreviation(typeEquipement.getAbreviation());
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
        responseDto.setQuantieStock(lot.getQuantiteStock());
        responseDto.setProviderName(lot.getProvider().getNom());
        responseDto.setCaracteristiques(lot.getCaracteristiques());
        responseDto.setTypeEquipementName(lot.getTypeEquipement().getNom());
        Set<String> equipements=lot.getEquipements()
                .stream()
                .map(equipement -> equipement.getNumeroUnique())
                .collect(Collectors.toSet());
        return responseDto;
    }

    public static EquipementResponseDto EquipementtoEquipementResponseDto(Equipement equipement){
        EquipementResponseDto responseDto=new EquipementResponseDto();
        responseDto.setId(equipement.getId());
        responseDto.setNumeroUnique(equipement.getNumeroUnique());
        responseDto.setNumeroSerie(equipement.getNumeroSerie());
        responseDto.setNroLot(equipement.getLot().getNroLot());
        return responseDto;
    }

    public static SubdivisionResponseDto subdivisionToSubdivisionResponseDto(Subdivision subdivision){
        SubdivisionResponseDto responseDto=new SubdivisionResponseDto();
        responseDto.setId(subdivision.getId());
        responseDto.setNom(subdivision.getNom());
        if(subdivision.getParent()!=null)
            responseDto.setParent(subdivision.getParent().getNom());
        responseDto.setType(String.valueOf(subdivision.getType()));
        Set<String> subdivisions=subdivision.getSubdivisions()
                .stream()
                .map(sub->subdivision.getParent().getNom())
                .collect(Collectors.toSet());
        responseDto.setSubdivisions(subdivisions);
        return responseDto;
    }
}
