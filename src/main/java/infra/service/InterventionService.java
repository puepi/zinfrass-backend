package infra.service;

import infra.dto.Mapper;
import infra.dto.request.InterventionRequestDto;
import infra.dto.response.InterventionResponseDto;
import infra.enums.Origine;
import infra.enums.TypeIncidentIntervention;
import infra.model.Intervention;
import infra.repository.InterventionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InterventionService implements IInterventionService{
    private final InterventionRepository interventionRepository;
    private final EquipementService equipementService;
    @Override
    public List<InterventionResponseDto> addLot(InterventionRequestDto requestDto) throws  NumberFormatException{
        Intervention intervention=new Intervention();

        if(requestDto.getRaison().equalsIgnoreCase("Réception")){
            List<Intervention> interventions = new ArrayList<>();
            List<String> identifiants=equipementService.getEquipementsFromLot(Long.valueOf(requestDto.getObjet()))
                    .stream().map(equipement->equipement.getNumeroUnique()).toList();
            for(String id:identifiants){
                intervention.setNomsIntervenant(requestDto.getNomsIntervenant());
                intervention.setPoste(requestDto.getPoste());
                intervention.setService(requestDto.getService());
                intervention.setObjet(requestDto.getObjet());
                intervention.setLieu(requestDto.getLieu());
                intervention.setObservations(requestDto.getObservations());
                intervention.setDateIntervention(requestDto.getDateIntervention());
                intervention.setObjet(requestDto.getObjet());
                intervention.setPosition_equipement("en stock");
                intervention.setRaison(Origine.valueOf(requestDto.getRaison()));
                intervention.setIdentifiant(id);
                intervention.setLieu(requestDto.getLieu());
                intervention.setEtat_objet(requestDto.getEtat_objet());
                intervention.setNature(TypeIncidentIntervention.LOT);
                intervention.setRaison(Origine.RECEPTION);
                interventions.add(intervention);
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
