package infra.service;

import infra.dto.Mapper;
import infra.dto.request.InterventionRequestDto;
import infra.dto.response.InterventionResponseDto;
import infra.dto.response.LotResponseDto;
import infra.enums.Origine;
import infra.enums.TypeIncidentIntervention;
import infra.model.Intervention;
import infra.repository.InterventionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InterventionService implements IInterventionService{
    private final InterventionRepository interventionRepository;
    private final EquipementService equipementService;
    private final LotService lotService;

    @Transactional
    @Override
    public List<InterventionResponseDto> addLot(InterventionRequestDto requestDto) throws  NumberFormatException{


        if(Origine.RECEPTION.fromString(requestDto.getRaison()).equals(Origine.RECEPTION)){
            List<Intervention> interventions = new ArrayList<>();
            List<String> identifiants=equipementService.getEquipementsFromLot(Long.valueOf(requestDto.getObjet()))
                    .stream().map(equipement->equipement.getNumeroUnique()).toList();
            System.out.println("identifiants = " + identifiants);
            for(String id:identifiants){
                Intervention intervention=new Intervention();
                intervention.setNomsIntervenant(requestDto.getNomsIntervenant());
                intervention.setPoste(requestDto.getPoste());
                intervention.setService(requestDto.getService());
                intervention.setObjet(requestDto.getObjet());
                intervention.setLieu(requestDto.getLieu());
                intervention.setObservations("Réception effectuée avec succès après mise au magasin");
                intervention.setDateIntervention(LocalDate.now());
                intervention.setPosition_equipement("en stock");
                intervention.setRaison(Origine.fromString(requestDto.getRaison()));
                intervention.setIdentifiant(id);
                intervention.setLieu(requestDto.getLieu());
                intervention.setEtat_objet(requestDto.getEtat_objet());
                intervention.setNature(TypeIncidentIntervention.LOT);
                intervention.setRef_autorisation(requestDto.getRef_autorisation());
                interventions.add(intervention);
                LotResponseDto lotResponseDto=lotService.changeQuantity(Long.parseLong(requestDto.getObjet()),0);
            }
            return Mapper.interventionsToListOfInterventionResponseDto(interventionRepository.saveAll(interventions));
        }
        return null;
    }

    @Override
    public List<InterventionResponseDto> getAllInterventions() {
        return List.of();
    }
}
