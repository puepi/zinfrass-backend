package infra.service;

import infra.dto.request.BatimentRequestDto;
import infra.model.Batiment;
import org.springframework.stereotype.Service;

@Service
public interface IBatimentService {
    Batiment addBatiment(BatimentRequestDto batimentRequestDto);
}
