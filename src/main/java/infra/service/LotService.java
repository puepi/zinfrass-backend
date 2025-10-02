package infra.service;

import infra.dto.Mapper;
import infra.dto.request.EquipementRequestDto;
import infra.dto.request.LotRequestDto;
import infra.dto.response.EquipementResponseDto;
import infra.dto.response.LotResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.model.Equipement;
import infra.model.Fournisseur;
import infra.model.Lot;
import infra.model.TypeEquipement;
import infra.repository.FournisseurRepository;
import infra.repository.LotRepository;
import infra.repository.TypeEquipementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class LotService implements ILotService{
    private final LotRepository lotRepository;
    private final FournisseurRepository fournisseurRepository;
    private  final TypeEquipementService typeEquipementService;

    private static final DateTimeFormatter DATE_FR_FORMATTER = DateTimeFormatter.ofPattern("ddMMyyyy");

    public LotService(LotRepository lotRepository, FournisseurRepository fournisseurRepository, TypeEquipementRepository typeEquipementRepository, TypeEquipementService typeEquipementService) {
        this.lotRepository = lotRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.typeEquipementService = typeEquipementService;
    }

    @Override
    public LotResponseDto addLot(LotRequestDto request) {
        Lot lot=new Lot();

        lot.setCouleur(request.getCouleur());
        lot.setCaracteristiques(request.getCaracteristiques());
        lot.setMarque(request.getMarque());
        lot.setModele(request.getModele());
        lot.setDescriptive(request.getDescriptive());
        lot.setNomsLivreurs(request.getNomsLivreurs());
        lot.setTechniciens(request.getTechniciens());
        lot.setObservations(request.getObservations());
        lot.setDateLivraison(request.getDateReception());
//        lot.setQuantiteStock(request.getQuantiteStock());
        TypeEquipement typeEquipement=typeEquipementService.get(request.getTypeEquipementId());
        Fournisseur fournisseur=fournisseurRepository.findById(request.getProviderId()).orElseThrow(()->new ResourceNotFoundException("The provider name does not exist"));
        lot.setProvider(fournisseur);
        lot.setTypeEquipement(typeEquipement);
        for(EquipementRequestDto req: request.getEquipements()){
            lot.addEquipement(Mapper.equipementRequestToEquipement(req));
        }
        lot.setNroLot(genererNroLot(lot));
        lot.updateQuantiteStock();
        return Mapper.lotToLotResponseDto(lotRepository.save(lot));
    }

    @Override
    public Lot getLotById(Long lotId) {
        return lotRepository.findById(lotId).orElseThrow(()->new ResourceNotFoundException("Id Lot inexistant"));
    }

    @Override
    public List<LotResponseDto> getAllLots() {
        return Mapper.lotsToListOfLotsResponseDto(lotRepository.findAll());
    }

    @Override
    public String genererNroLot(Lot lot) {
        String fournisseurCode = lot.getProvider().getNom().toUpperCase().substring(0, 2); // suppose un champ code dans Fournisseur
        String typeCode = lot.getTypeEquipement().getAbreviation().toUpperCase();  // suppose un champ code dans TypeEquipement
        String marque = lot.getMarque().toUpperCase();
        String dateStr = lot.getDateLivraison().format(DATE_FR_FORMATTER);
        // Récupérer tous les lots existants pour cette combinaison
        List<Lot> lotsExistants = lotRepository.findByProviderAndTypeEquipementAndMarqueAndDateLivraison(
                lot.getProvider(), lot.getTypeEquipement(), lot.getMarque(), lot.getDateLivraison()
        );
        // Numéro séquentiel automatique
        int numeroSequence = lotsExistants.size() + 1;
        String seqStr = String.format("%03d", numeroSequence);
        return "Lot-" + seqStr + String.join("-", fournisseurCode, typeCode, dateStr);
    }

    @Override
    @Transactional
    public LotResponseDto changeQuantity(Long idLot, int qty) {
        // 1. Recherche de l'entité par ID. L'utilisation d'Optional est une bonne pratique.
        Optional<Lot> optionalLot = lotRepository.findById(idLot);

        if (optionalLot.isPresent()) {
            Lot lot = optionalLot.get();

            // 2. Mise à jour de la propriété de l'entité.
            lot.updateQuantiteStock();

            // 3. Sauvegarde de l'entité. Puisque l'entité a déjà un ID,
            //    JpaRepository effectue automatiquement une opération UPDATE.
            return Mapper.lotToLotResponseDto(lotRepository.save(lot));
        } else {
            // 4. Si non trouvé, lever une exception qui sera gérée par le contrôleur
            //    pour retourner un statut HTTP 404 NOT FOUND.
            throw new RuntimeException("Lot non trouvé avec l'ID: " + idLot);
        }
    }

    @Override
    @Transactional
    public void deleteLot(Long idLot) {
        lotRepository.deleteById(idLot);
    }

    @Override
    public LotResponseDto addEquipementsToLot(Long idLot, List<EquipementRequestDto> equipements) {
        Lot lot=lotRepository.findById(idLot).orElseThrow(()->new ResourceNotFoundException("Id Lot inexistant"));
        // 2️⃣ Convert each EquipementRequestDto to Equipement entity and attach to Lot
        for (EquipementRequestDto dto : equipements) {
            Equipement equipement = Mapper.equipementRequestToEquipement(dto); // assuming you have this mapper
            lot.addEquipement(equipement); // automatically sets equipement.lot = lot
        }

        // 3️⃣ Update quantiteStock automatically
        lot.updateQuantiteStock(); // or let @PrePersist/@PreUpdate handle it

        // 4️⃣ Save Lot (cascades to new Equipements because of CascadeType.ALL)
        Lot savedLot = lotRepository.save(lot);

        // 5️⃣ Return response DTO
        return Mapper.lotToLotResponseDto(savedLot);
    }
}
