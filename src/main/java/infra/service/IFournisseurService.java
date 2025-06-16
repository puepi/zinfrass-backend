package infra.service;

import infra.dto.request.FournisseurRequestDto;
import infra.dto.response.FournisseurResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface IFournisseurService {
    FournisseurResponseDto addFournisseur(FournisseurRequestDto request);

}
