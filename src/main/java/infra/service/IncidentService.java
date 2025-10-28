package infra.service;

import infra.dto.Mapper;
import infra.dto.request.IncidentRequestDto;
import infra.dto.response.IncidentResponseDto;
import infra.enums.TypeIncidentIntervention;
import infra.model.Incident;
import infra.repository.IncidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentService implements IIncidentService {
    private final IncidentRepository incidentRepository;
    @Override
    public IncidentResponseDto addIncident(IncidentRequestDto requestDto) {
        Incident incident=new Incident();
        incident.setNroIncident(requestDto.getNroIncident());
        incident.setDescription(requestDto.getDescription());
        incident.setNomsDeclarant(requestDto.getNomsDeclarant());
        incident.setDateIncident(requestDto.getDateIncident());
        incident.setNomStructure(requestDto.getNomStructure());
        incident.setPoste(requestDto.getPoste());
        incident.setResolu(requestDto.getResolu());
        incident.setType(TypeIncidentIntervention.fromString(requestDto.getNature()));
        incident.setObjet(requestDto.getObjet());
        incident.setIdentifiant(requestDto.getIdentifiant());
        return Mapper.incidentToIncidentResponseDto(incidentRepository.save(incident));
    }

    @Override
    public List<IncidentResponseDto> getAllIncidents() {
        List<Incident> incidents=incidentRepository.findAll();
        return Mapper.incidentstoListOfIncidentResponseDto(incidents);
    }

    @Override
    public Page<IncidentResponseDto> getPaginatedAllIncidents(Pageable pageable) {
        Page<Incident> incidents=incidentRepository.findAll(pageable);
        return incidents.map(Mapper::incidentToIncidentResponseDto);
    }

    @Override
    public Incident getByNroIncident(String nroIncident) {
        Incident incident=incidentRepository.findByNroIncident(nroIncident);
        return incident;
    }

}
