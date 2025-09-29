package infra.service;

import infra.dto.request.InterventionRequestDto;
import infra.dto.response.InterventionResponseDto;
import infra.model.Intervention;
import infra.repository.InterventionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterventionService implements IInterventionService{
    private final InterventionRepository interventionRepository;
    @Override
    public InterventionResponseDto add(InterventionRequestDto requestDto) {
        Intervention intervention=new Intervention();
        intervention.setNomsIntervenant(requestDto.getNomsIntervenant());
        intervention.setPoste(requestDto.getPoste());
        intervention.setService(requestDto.getService());
        intervention.setSur(requestDto.getSur());
        intervention.setObjet(requestDto.getObjet());
        intervention.setIdentifiant(requestDto.getIdentifiant());
        intervention.setLieu(requestDto.getLieu());
        intervention.setObservations(requestDto.getObservations());
        intervention.setDateIntervention(requestDto.getDateIntervention());

        if(requestDto.getRaison().equalsIgnoreCase("Réception")){

        }
        return null;
    }

    @Override
    public List<InterventionResponseDto> getAllInterventions() {
        return List.of();
    }
}
