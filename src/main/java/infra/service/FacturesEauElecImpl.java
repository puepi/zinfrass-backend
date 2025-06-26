package infra.service;

import infra.dto.Mapper;
import infra.dto.request.BatimentResponseDto;
import infra.dto.request.FacturesEauElecRequestDto;
import infra.dto.response.FacturesEauElecResponseDto;
import infra.model.Batiment;
import infra.model.FacturesEauElec;
import infra.repository.FacturesEauElecRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacturesEauElecImpl implements FacturesEauElecService {
    private final FacturesEauElecRepository facturesEauElecRepository;
    private final IBatimentService batimentService;
    @Override
    public FacturesEauElecResponseDto addFacturesEauElec(FacturesEauElecRequestDto request) {
        Batiment batiment=batimentService.getBatiment(request.getBatimentId());
        FacturesEauElec facturesEauElec =new FacturesEauElec();
        facturesEauElec.setBatiment(batiment);
        facturesEauElec.setType(request.getType());
        facturesEauElec.setNumeroFacture(request.getNumeroFacture());
        facturesEauElec.setFin(request.getFin());
        facturesEauElec.setDebut(request.getDebut());
        facturesEauElec.setConsommation(request.getConsommation());
        facturesEauElec.setAncienIndex(request.getAncienIndex());
        facturesEauElec.setNouvelIndex(request.getNouvelIndex());
        facturesEauElec.setMontant(request.getMontant());
        facturesEauElec.setNuméroCompteur(request.getNuméroCompteur());
        return Mapper.facturestoFacturesResponse(facturesEauElecRepository.save(facturesEauElec));
    }
}
