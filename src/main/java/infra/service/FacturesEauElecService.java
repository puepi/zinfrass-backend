package infra.service;

import infra.dto.request.FacturesEauElecRequestDto;
import infra.dto.response.FacturesEauElecResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FacturesEauElecService {
    FacturesEauElecResponseDto addFacturesEauElec(FacturesEauElecRequestDto request);
    List<FacturesEauElecResponseDto> getAllFactures();
}
