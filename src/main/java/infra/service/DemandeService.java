package infra.service;

import infra.dto.Mapper;
import infra.dto.request.DemandeRequestDto;
import infra.dto.response.DemandeResponseDto;
import infra.model.Demande;
import infra.repository.DemandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DemandeService implements IDemandeService {
    private final DemandeRepository demandeRepository;

    @Override
    public DemandeResponseDto addDemande(DemandeRequestDto requestDto) {
        Demande demande=new Demande();
        demande.setNoms(requestDto.getNoms());
        demande.setObjet(requestDto.getObjet());
        demande.setDateReception(requestDto.getDateReception());
        demande.setService(requestDto.getService());
        demande.setPoste(requestDto.getPoste());
        demande.setTypeEquipement(requestDto.getTypeEquipement());
        demande.setCatégorieEquipement(requestDto.getCatégorieEquipement());

        return Mapper.demandeToDemandeResponseDto(demandeRepository.save(demande));
    }

    @Override
    public List<DemandeResponseDto> getAllDemandes() {
        List<Demande> demandes=demandeRepository.findAll();
        return Mapper.demandesToListofDemandeResponseDto(demandes);
    }
}
