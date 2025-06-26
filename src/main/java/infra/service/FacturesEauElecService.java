package infra.service;

import infra.dto.request.FacturesEauElecRequestDto;
import infra.dto.response.FacturesEauElecResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface FacturesEauElecService {
    FacturesEauElecResponseDto addFacturesEauElec(FacturesEauElecRequestDto request);
}
