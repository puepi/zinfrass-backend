package infra.service;

import infra.dto.Mapper;
import infra.dto.request.LotRequestDto;
import infra.dto.response.LotResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.model.Fournisseur;
import infra.model.Lot;
import infra.repository.FournisseurRepository;
import infra.repository.LotRepository;
import org.springframework.stereotype.Service;

@Service
public class LotService implements ILotService{
    private final LotRepository lotRepository;
    private final FournisseurRepository fournisseurRepository;

    public LotService(LotRepository lotRepository, FournisseurRepository fournisseurRepository) {
        this.lotRepository = lotRepository;
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public LotResponseDto addLot(LotRequestDto request) {
        Lot lot=new Lot();
        lot.setNroLot(request.getNroLot());
        lot.setCouleur(request.getCouleur());
        lot.setCaracteristiques(request.getCaracteristiques());
        lot.setMarque(request.getMarque());
        lot.setModele(request.getModele());
        lot.setObservations(request.getObservations());
        lot.setDateLivraison(request.getDateLivraison());
        Fournisseur fournisseur=fournisseurRepository.findByNom(request.getProviderName()).orElseThrow(()->new ResourceNotFoundException("The provider name does not exist"));
        lot.setProvider(fournisseur);
        return Mapper.lotToLotResponseDto(lotRepository.save(lot));
    }
}
