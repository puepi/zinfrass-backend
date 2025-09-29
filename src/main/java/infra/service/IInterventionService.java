package infra.service;

import infra.dto.request.InterventionRequestDto;
import infra.dto.response.InterventionResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IInterventionService {
    InterventionResponseDto add(InterventionRequestDto requestDto);
    List<InterventionResponseDto> getAllInterventions();
}
