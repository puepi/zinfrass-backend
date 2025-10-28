package infra.service;

import infra.dto.request.InterventionRequestDto;
import infra.dto.response.InterventionResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IInterventionService {
    List<InterventionResponseDto> addLot(InterventionRequestDto requestDto);
    List<InterventionResponseDto> getAllInterventions();

    Page<InterventionResponseDto> getPaginatedAllInterventions(Pageable pageable);

    InterventionResponseDto addInstallation(InterventionRequestDto requestDto);

    void deleteIntervention(Long id);

    InterventionResponseDto addDepannage(InterventionRequestDto requestDto);
}
