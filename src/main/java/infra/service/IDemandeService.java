package infra.service;

import infra.dto.request.DemandeRequestDto;
import infra.dto.response.DemandeResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDemandeService {
    DemandeResponseDto addDemande(DemandeRequestDto requestDto);
    List<DemandeResponseDto> getAllDemandes();
}
