package infra.dto;


import infra.dto.request.EquipementRequestDto;
import infra.dto.response.BatimentResponseDto;
import infra.dto.response.*;
import infra.model.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Mapper {
    public static TypeEquipementResponseDto typeEquipementToTypeEquipementResponseDto(TypeEquipement typeEquipement) {
        TypeEquipementResponseDto responseDto = new TypeEquipementResponseDto();
        responseDto.setId(typeEquipement.getId());
        responseDto.setNom(typeEquipement.getNom());
        responseDto.setCaracteristiques(typeEquipement.getCaracteristiques());
        responseDto.setCategorieNom(typeEquipement.getCategorie().getNom());
        responseDto.setAbreviation(typeEquipement.getAbreviation());
        List<String> lots = typeEquipement.getLots()
                .stream()
                .map(lot -> lot.getNroLot())
                .toList();
        responseDto.setNrosLot(lots);
        return responseDto;
    }

    public static CategorieResponseDto categorieToCategorieResponseDto(Categorie categorie) {
        CategorieResponseDto responseDto = new CategorieResponseDto();
        responseDto.setId(categorie.getId());
        responseDto.setNom(categorie.getNom());
//        Set<String> types = categorie.getTypeEquipements()
//                .stream()
//                .map(type -> type.getNom())
//                .collect(Collectors.toSet());
//        Set<String> types=new HashSet<>(Arrays.asList("UC,EC,LAPT"));
        // CRITICAL FIX: Create a defensive copy of the collection BEFORE streaming


//        responseDto.setTypesEquipement(types);

        return responseDto;
    }

    public static List<TypeEquipementResponseDto> typesEquipementToListOfTypeEquipementResponseDto(List<TypeEquipement> typeEquipements){

        return typeEquipements.stream()
                .map(typeEquipement -> typeEquipementToTypeEquipementResponseDto(typeEquipement))
                .toList();
    }

    public static List<CategorieResponseDto> categoriesToListOfCategorieResponseDto(List<Categorie> categories){

        return categories.stream()
                .map(categorie -> categorieToCategorieResponseDto(categorie))
                .toList();
    }

    public static FournisseurResponseDto fournisseurToFournisseurResponseDto(Fournisseur fournisseur) {
        FournisseurResponseDto responseDto = new FournisseurResponseDto();
        responseDto.setId(fournisseur.getId());
        responseDto.setNom(fournisseur.getNom());
        responseDto.setNIU(fournisseur.getNIU());
        responseDto.setContact(fournisseur.getContact());
        responseDto.setAdresse(fournisseur.getAdresse());
        responseDto.setEmail(fournisseur.getEmail());
        responseDto.setRepresentant(fournisseur.getRepresentant());
        responseDto.setType(fournisseur.getType());
        Set<String> types = fournisseur.getLots()
                .stream()
                .map(lot -> lot.getTypeEquipement().getNom())
                .collect(Collectors.toSet());
        responseDto.setTypesEquipement(types);
        return responseDto;
    }

    public static List<FournisseurResponseDto> fournisseurstoListOfFournisseurResponseDto(List<Fournisseur> fournisseurs){
        List<FournisseurResponseDto> responseDtos=fournisseurs.stream()
                .map(fournisseur -> fournisseurToFournisseurResponseDto(fournisseur))
                .toList();
        return responseDtos;
    }

    public static LotResponseDto lotToLotResponseDto(Lot lot) {
        LotResponseDto responseDto = new LotResponseDto();
        responseDto.setId(lot.getId());
        responseDto.setCouleur(lot.getCouleur());
        responseDto.setMarque(lot.getMarque());
        responseDto.setModele(lot.getModele());
        responseDto.setNroLot(lot.getNroLot());
        responseDto.setDescriptive(lot.getDescriptive());
        responseDto.setObservations(lot.getObservations());
        responseDto.setDateReception(lot.getDateLivraison());
        responseDto.setQuantiteStock(lot.getQuantiteStock());
        responseDto.setProviderName(lot.getProvider().getNom());
        responseDto.setCaracteristiques(lot.getCaracteristiques());
        responseDto.setNomsLivreurs(lot.getNomsLivreurs());
        responseDto.setTechniciens(lot.getTechniciens());
        responseDto.setTypeEquipementName(lot.getTypeEquipement().getNom());
        Set<String> equipements = lot.getEquipements()
                .stream()
                .map(equipement -> equipement.getNumeroUnique() + "/"
                        + equipement.getNumeroSerie())
                .collect(Collectors.toSet());
        responseDto.setEquipements(equipements);
        return responseDto;
    }

    public static List<LotResponseDto> lotsToListOfLotsResponseDto(List<Lot> lots) {
        return lots.stream()
                .map(lot->lotToLotResponseDto(lot))
                .toList();
    }

    public static EquipementResponseDto EquipementtoEquipementResponseDto(Equipement equipement) {
        EquipementResponseDto responseDto = new EquipementResponseDto();
        responseDto.setId(equipement.getId());
        responseDto.setNumeroUnique(equipement.getNumeroUnique());
        responseDto.setNumeroSerie(equipement.getNumeroSerie());
        responseDto.setNroLot(equipement.getLot().getNroLot());
        return responseDto;
    }

    public static Equipement equipementRequestToEquipement(EquipementRequestDto requestDto) {
        Equipement eq=new Equipement();
        eq.setNumeroSerie(requestDto.getNumeroSerie());
        eq.setNumeroUnique(requestDto.getNumeroUnique());
        return eq;
    }

    public static SubdivisionResponseDto subdivisionToSubdivisionResponseDto(Subdivision subdivision) {
        SubdivisionResponseDto responseDto = new SubdivisionResponseDto();
        responseDto.setId(subdivision.getId());
        responseDto.setNom(subdivision.getNom());
        responseDto.setType(subdivision.getType().toString());
        if (subdivision.getParent() != null)
            responseDto.setParent(subdivision.getParent().getNom());
//        responseDto.setType(String.valueOf(subdivision.getType()));
        Set<String> subdivisions = subdivision.getSubdivisions()
                .stream()
                .filter(sub->sub.getParent().getId()!=sub.getId())
                .map(sub -> sub.getNom())
                .collect(Collectors.toSet());
        responseDto.setSubdivisions(subdivisions);
        return responseDto;
    }

    public static List<SubdivisionResponseDto> subdivisonsToListOfSubdivisionResponseDto(List<Subdivision> subdivisions) {
        List<SubdivisionResponseDto> subdivisionsDto = subdivisions.stream()
                .map(subdivision -> subdivisionToSubdivisionResponseDto(subdivision))
                .toList();
        return subdivisionsDto;
    }

    public static StructureResponseDto structureToStructureResponseDto(Structure structure) {
        StructureResponseDto responseDto = new StructureResponseDto();
        responseDto.setId(structure.getId());
        responseDto.setNom(structure.getNom());
        responseDto.setAbreviation(structure.getAbreviation());
        if (structure.getParent() != null)
            responseDto.setParent(structure.getParent().getNom());
        responseDto.setType(String.valueOf(structure.getType()));
        responseDto.setSubdivision(Mapper.subdivisionToSubdivisionResponseDto(structure.getSubdivision()));
        Set<String> structures = structure.getStructures()
                .stream()
                .filter(s->s.getId()!=s.getParent().getId())
                .map(sub -> sub.getNom())
                .collect(Collectors.toSet());
        responseDto.setStructures(structures);
        responseDto.setOccupants(structure.getOccupations().stream().map(occupation->
                    occupation.getPoste().getNom()
                ).collect(Collectors.toSet()));
        return responseDto;
    }

    public static List<StructureResponseDto> structuresToListOfStructureResponseDto(List<Structure> structures) {
        List<StructureResponseDto> structuresDto = structures.stream()
                .map(structure -> structureToStructureResponseDto(structure))
                .toList();
        return structuresDto;
    }

    public static PosteResponseDto posteToPosteResponseDto(Poste poste) {
        PosteResponseDto responseDto = new PosteResponseDto();
        responseDto.setId(poste.getId());
        responseDto.setNom(poste.getNom());
        responseDto.setRang(String.valueOf(poste.getRang()));
        responseDto.setAbreviation(poste.getAbreviation());
        return responseDto;
    }

    public static List<PosteResponseDto> postesToListOfPosteResponseDto(List<Poste> postes) {
        List<PosteResponseDto> posteResponseDtos = postes.stream()
                .map(poste -> posteToPosteResponseDto(poste))
                .toList();
        return posteResponseDtos;
    }

    public static ResponsabilisationResponseDto responsabilisationToResponsabilisationResponseDto(Responsabilisation responsabilisation) {
        ResponsabilisationResponseDto responseDto = new ResponsabilisationResponseDto();
        responseDto.setId(responsabilisation.getId());
        responseDto.setNomStructure(responsabilisation.getStructure().getNom());
        responseDto.setNomPoste(responsabilisation.getPoste().getNom());
        responseDto.setDebut(responsabilisation.getDebut());
        responsabilisation.setFin(responsabilisation.getFin());
        responseDto.setNoms(responsabilisation.getNomsPrenoms());
        responseDto.setActif(responsabilisation.getActif());
        return responseDto;
    }

    public static List<ResponsabilisationResponseDto> responsabilisationsToListOfResponsabilisationResponseDto(List<Responsabilisation> responsabilisations) {
        List<ResponsabilisationResponseDto> responseDtos = responsabilisations.stream()
                .map(responsabilisation -> responsabilisationToResponsabilisationResponseDto(responsabilisation))
                .toList();
        return responseDtos;
    }

    public static BatimentResponseDto batimentToBatimentResponseDto(Batiment batiment) {
        BatimentResponseDto responseDto = new BatimentResponseDto();
        responseDto.setId(batiment.getId());
        responseDto.setNom(batiment.getNom());
        responseDto.setNature(batiment.getNature());
        responseDto.setRetrocede(batiment.isRetrocede());
        responseDto.setDateRetrocession(batiment.getDateRetrocession());
        responseDto.setDescription(batiment.getDescription());
        responseDto.setSubdivisionName(batiment.getSubdivision().getNom());
        return responseDto;
    }

    public static List<BatimentResponseDto> batimentsToListOfBatimentResponseDto(List<Batiment> batiments) {
        List<BatimentResponseDto> responseDtos = batiments.stream()
                .map(batiment -> batimentToBatimentResponseDto(batiment))
                .toList();
        return responseDtos;
    }

    public static FacturesEauElecResponseDto facturestoFacturesResponse(FacturesEauElec facturesEauElec) {
        FacturesEauElecResponseDto responseDto = new FacturesEauElecResponseDto();
        responseDto.setId(facturesEauElec.getId());
        responseDto.setDebut(facturesEauElec.getDebut());
        responseDto.setFin(facturesEauElec.getFin());
        responseDto.setConsommation(facturesEauElec.getConsommation());
        responseDto.setBatimentName(facturesEauElec.getBatiment().getNom());
        responseDto.setMontant(facturesEauElec.getMontant());
        responseDto.setAncienIndex(facturesEauElec.getAncienIndex());
        responseDto.setNouvelIndex(facturesEauElec.getNouvelIndex());
        responseDto.setType(facturesEauElec.getType());
        responseDto.setNumeroFacture(facturesEauElec.getNumeroFacture());
        responseDto.setNuméroCompteur(facturesEauElec.getNuméroCompteur());
        responseDto.setSubdivisionName(facturesEauElec.getBatiment().getSubdivision().getNom());
        return responseDto;
    }

    public static List<FacturesEauElecResponseDto> facturesToListOfFactures(List<FacturesEauElec> factures) {
        return factures.stream()
                .map(facture->facturestoFacturesResponse(facture))
                .toList();
    }

    public static EspaceResponseDto espaceToEspaceResponseDto(Espace espace) {
        EspaceResponseDto responseDto = new EspaceResponseDto();
        responseDto.setId(espace.getId());
        responseDto.setNom(espace.getNom());
        responseDto.setBatimentNom(espace.getBatiment().getNom());
        responseDto.setDimensions(espace.getDimensions());
        responseDto.setUsage(String.valueOf(espace.getUsages()));
        responseDto.setPosition(espace.getPosition());
        return responseDto;
    }


    public static List<EspaceResponseDto> espacesToListOfEspacesResponseDto(List<Espace> espaces){
        return espaces.stream()
                .map(espace->espaceToEspaceResponseDto(espace))
                .toList();
    }

    public static List<TypeEquipementResponseDto> typeEquipementToListOfTypeEquipementResponseDto(List<TypeEquipement> typeEquipements) {
        return typeEquipements.stream()
                .map(type->typeEquipementToTypeEquipementResponseDto(type))
                .toList();
    }


    public static DemandeResponseDto demandeToDemandeResponseDto(Demande demande) {
        DemandeResponseDto responseDto=new DemandeResponseDto();
        responseDto.setId(demande.getId());
        responseDto.setObjet(demande.getObjet());
        responseDto.setService(demande.getService());
        responseDto.setPoste(demande.getPoste());
        responseDto.setNoms(demande.getNoms());
        responseDto.setDateReception(demande.getDateReception());
        responseDto.setTypeEquipement(demande.getTypeEquipement());
        responseDto.setCatégorieEquipement(demande.getCatégorieEquipement());
        return responseDto;
    }

    public static List<DemandeResponseDto> demandesToListofDemandeResponseDto(List<Demande> demandes) {
        return demandes.stream()
                .map(demande -> demandeToDemandeResponseDto(demande))
                .toList();
    }

    public static PersonnelResponseDto personnelToPersonnelResponse(Personnel personnel) {
        PersonnelResponseDto responseDto=new PersonnelResponseDto();
        responseDto.setNoms(personnel.getNoms());
        responseDto.setPrenoms(personnel.getPrenoms());
        responseDto.setMatricule(personnel.getMatricule());
        responseDto.setId(personnel.getId());
        responseDto.setGenre(String.valueOf(personnel.getGenre()));
        return responseDto;
    }

    public static List<PersonnelResponseDto> personnelsToListOfPersonnelResponseDto(List<Personnel> personnels) {
        return personnels.stream()
                .map(personnel -> personnelToPersonnelResponse(personnel))
                .toList();
    }
}