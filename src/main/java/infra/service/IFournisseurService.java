package infra.service;

import infra.dto.request.FournisseurRequestDto;
import infra.dto.response.FournisseurResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFournisseurService {
    FournisseurResponseDto addFournisseur(FournisseurRequestDto request);

    List<FournisseurResponseDto> getFournisseurs();
}
