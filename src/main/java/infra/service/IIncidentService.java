package infra.service;

import infra.dto.request.IncidentRequestDto;
import infra.dto.response.IncidentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IIncidentService {
    IncidentResponseDto addIncident(IncidentRequestDto requestDto);
    List<IncidentResponseDto> getAllIncidents();
}
