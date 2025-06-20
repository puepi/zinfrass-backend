package infra.service;

import infra.dto.request.ResponsabilisationRequestDto;
import infra.dto.response.ResponsabilisationResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface IResponsabilisationService {
    ResponsabilisationResponseDto addResponsabilisation(ResponsabilisationRequestDto requestDto);
}
