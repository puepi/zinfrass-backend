package infra.service;

import infra.dto.Mapper;
import infra.dto.request.InterventionRequestDto;
import infra.dto.response.IncidentResponseDto;
import infra.dto.response.InterventionResponseDto;
import infra.dto.response.LotResponseDto;
import infra.enums.Origine;
import infra.enums.TypeIncidentIntervention;
import infra.model.Equipement;
import infra.model.Incident;
import infra.model.Intervention;
import infra.model.Lot;
import infra.repository.EquipementRepository;
import infra.repository.IncidentRepository;
import infra.repository.InterventionRepository;
import infra.repository.LotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    private final EquipementRepository equipementRepository;
    private final LotService lotService;
    private final IncidentService incidentService;
    private final LotRepository lotRepository;
    private final IncidentRepository incidentRepository;

    @Transactional
    @Override
    public List<InterventionResponseDto> addLot(InterventionRequestDto requestDto) throws  NumberFormatException{
        if(Origine.RECEPTION.fromString(requestDto.getRaison()).equals(Origine.RECEPTION)){

            List<Intervention> interventions = new ArrayList<>();
            Lot lot = lotService.getLotById(Long.valueOf(requestDto.getObjet()));
            System.out.println("lot = " + Mapper.lotToLotResponseDto(lot));
            List<String> identifiants=equipementService.getEquipementsFromLot(Long.valueOf(requestDto.getObjet()))
                    .stream().map(equipement->equipement.getNumeroUnique()).toList();
            System.out.println("identifiants = " + identifiants);

            for(String id:identifiants){
                Intervention intervention=new Intervention();
                intervention.setNomsIntervenant(requestDto.getNomsIntervenant());
                intervention.setPoste(requestDto.getPoste());
                intervention.setService(requestDto.getService());
                intervention.setObjet(lot.getNroLot());
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

//                LotResponseDto lotResponseDto=lotService.changeQuantity(Long.parseLong(requestDto.getObjet()),0);
            }

            for (Equipement eq : lot.getEquipements()) {
                eq.setLastLotId(eq.getLot().getId());        // ✅ keep trace// optional, human readable
                eq.setLot(null);                             // unlink
                eq.setLieu("Salle Serveur/Magasin");
                eq.setCurrentPosition("en stock");
            }
//             Remove all equipements to set quantity to 0
            lot.getEquipements().clear();
            lot.updateQuantiteStock(); // optional, will also be done automatically by @PreUpdate
            lotRepository.save(lot); // make sure this persists the change
            return Mapper.interventionsToListOfInterventionResponseDto(interventionRepository.saveAll(interventions));
        }else{
            return null;
        }
    }

    @Override
    public List<InterventionResponseDto> getAllInterventions() {
        List<Intervention> interventions=interventionRepository.findAll();
        return interventions.stream().map(Mapper::interventionToInterventionResponseDto).toList();
    }

    @Override
    public Page<InterventionResponseDto> getPaginatedAllInterventions(Pageable pageable) {
        return interventionRepository.findAll(pageable).map(Mapper::interventionToInterventionResponseDto);
    }


    @Override
    @Transactional
    public InterventionResponseDto addInstallation(InterventionRequestDto requestDto) {
        if(Origine.INSTALLATION.fromString(requestDto.getRaison()).equals(Origine.INSTALLATION)){
            Intervention intervention=new Intervention();
            intervention.setNomsIntervenant(requestDto.getNomsIntervenant());
            intervention.setPoste(requestDto.getPoste());
            intervention.setService(requestDto.getService());
            intervention.setObjet(requestDto.getObjet());
            intervention.setObservations(requestDto.getObservations());
            intervention.setDateIntervention(requestDto.getDateIntervention());
            intervention.setPosition_equipement(requestDto.getPosition_equipement());
            intervention.setRaison(Origine.fromString(requestDto.getRaison()));
            intervention.setIdentifiant(requestDto.getIdentifiant());
            intervention.setLieu(requestDto.getLieu());
            //get equipement by numero_unique and update lieu and current_position
            Equipement equipement=equipementService.getEquipementByNumeroUnique(requestDto.getIdentifiant());
            equipement.setLieu(requestDto.getLieu());
            equipement.setCurrentPosition(requestDto.getPosition_equipement());
            equipementRepository.save(equipement);
            intervention.setEtat_objet(requestDto.getEtat_objet());
            intervention.setNature(TypeIncidentIntervention.fromString(requestDto.getNature()));
            intervention.setRef_autorisation(requestDto.getRef_autorisation());
            intervention.setPoste_affecte(requestDto.getPoste_affecte());
            intervention.setStructure_affecte(requestDto.getStructure_affecte());
            intervention.setPersonne_affecte(requestDto.getPersonne_affecte());
            return Mapper.interventionToInterventionResponseDto(interventionRepository.save(intervention));
        }
        return null;
    }

    @Override
    public void deleteIntervention(Long id) {
        interventionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public InterventionResponseDto addDepannage(InterventionRequestDto requestDto) {
        if(Origine.DEPANNAGE.fromString(requestDto.getRaison()).equals(Origine.DEPANNAGE)){
            Intervention intervention=new Intervention();
            intervention.setNomsIntervenant(requestDto.getNomsIntervenant());
            intervention.setPoste(requestDto.getPoste());
            intervention.setService(requestDto.getService());
            intervention.setObjet(requestDto.getObjet());
            intervention.setObservations(requestDto.getObservations());
            intervention.setDateIntervention(requestDto.getDateIntervention());
            intervention.setPosition_equipement(requestDto.getPosition_equipement());
            intervention.setRaison(Origine.fromString(requestDto.getRaison()));
            intervention.setIdentifiant(requestDto.getIdentifiant());
            intervention.setLieu(requestDto.getLieu());
            intervention.setDiagnostic(requestDto.getDiagnostic());
            intervention.setSolution(requestDto.getSolution());
            //get equipement by numero_unique and update lieu and current_position
            Equipement equipement=equipementService.getEquipementByNumeroUnique(requestDto.getIdentifiant());
            equipement.setLieu(requestDto.getLieu());
            equipement.setCurrentPosition(requestDto.getPosition_equipement());
            equipementRepository.save(equipement);
            intervention.setEtat_objet(requestDto.getEtat_objet());
            intervention.setNature(TypeIncidentIntervention.fromString(requestDto.getNature()));
            intervention.setRef_autorisation(requestDto.getRef_autorisation());
            intervention.setPoste_affecte(requestDto.getPoste_affecte());
            intervention.setStructure_affecte(requestDto.getStructure_affecte());
            intervention.setPersonne_affecte(requestDto.getPersonne_affecte());
            intervention.setNroIncident(requestDto.getNroIncident());
            intervention.setResolu(requestDto.getResolu());
            if(requestDto.getResolu().equals("oui")){
                Incident incident=incidentService.getByNroIncident(requestDto.getNroIncident());
                incident.setResolu("oui");
                incidentRepository.save(incident);
            }
            return Mapper.interventionToInterventionResponseDto(interventionRepository.save(intervention));
        }
        return null;
    }
}
