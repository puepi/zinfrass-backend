package infra.service;

import infra.dto.request.ResponsabilisationRequestDto;
import infra.dto.response.ResponsabilisationResponseDto;
import infra.model.Responsabilisation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IResponsabilisationService {
    ResponsabilisationResponseDto addResponsabilisation(ResponsabilisationRequestDto requestDto);

    Responsabilisation getResponsabilisation(Long structureId, Long posteId);

    List<ResponsabilisationResponseDto> getResponsabilisations();
    Page<ResponsabilisationResponseDto> getPaginatedAllResponsabilisations(Pageable pageable);
}
