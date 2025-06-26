package infra.service;

import infra.dto.request.BatimentRequestDto;
import infra.dto.request.BatimentResponseDto;
import infra.model.Batiment;
import org.springframework.stereotype.Service;

@Service
public interface IBatimentService {
    BatimentResponseDto addBatiment(BatimentRequestDto batimentRequestDto);
    Batiment getBatiment(Long id);
}
