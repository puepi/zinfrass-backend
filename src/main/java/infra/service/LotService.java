package infra.service;

import infra.dto.Mapper;
import infra.dto.request.LotRequestDto;
import infra.dto.response.LotResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.model.Fournisseur;
import infra.model.Lot;
import infra.model.TypeEquipement;
import infra.repository.FournisseurRepository;
import infra.repository.LotRepository;
import infra.repository.TypeEquipementRepository;
import org.springframework.stereotype.Service;

@Service
public class LotService implements ILotService{
    private final LotRepository lotRepository;
    private final FournisseurRepository fournisseurRepository;
    private  final TypeEquipementService typeEquipementService;

    public LotService(LotRepository lotRepository, FournisseurRepository fournisseurRepository, TypeEquipementRepository typeEquipementRepository, TypeEquipementService typeEquipementService) {
        this.lotRepository = lotRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.typeEquipementService = typeEquipementService;
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
        lot.setQuantiteStock(request.getQuantiteStock());
        TypeEquipement typeEquipement=typeEquipementService.get(request.getTypeEquipementId());
        Fournisseur fournisseur=fournisseurRepository.findById(request.getProviderId()).orElseThrow(()->new ResourceNotFoundException("The provider name does not exist"));
        lot.setProvider(fournisseur);
        lot.setTypeEquipement(typeEquipement);

        return Mapper.lotToLotResponseDto(lotRepository.save(lot));
    }

    @Override
    public Lot getLotById(Long lotId) {
        return lotRepository.findById(lotId).orElseThrow(()->new ResourceNotFoundException("Id Lot inexistant"));
    }
}
