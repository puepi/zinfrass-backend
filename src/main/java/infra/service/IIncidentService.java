package infra.service;

import infra.dto.request.IncidentRequestDto;
import infra.dto.response.IncidentResponseDto;
import infra.model.Incident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IIncidentService {
    IncidentResponseDto addIncident(IncidentRequestDto requestDto);
    List<IncidentResponseDto> getAllIncidents();

    Page<IncidentResponseDto> getPaginatedAllIncidents(Pageable pageable);

    Incident getByNroIncident(String nroIncident);

}
