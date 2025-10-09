package infra.service;

import infra.dto.Mapper;
import infra.dto.request.EquipementRequestDto;
import infra.dto.response.EquipementResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.model.Equipement;
import infra.model.Lot;
import infra.repository.EquipementRepository;
import infra.repository.LotRepository;
import infra.utility.EquipmentCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipementService implements IEquipementService{

    private final EquipementRepository equipementRepository;
    private final ILotService lotService;

    @Autowired
    public EquipementService(EquipementRepository equipementRepository, LotRepository lotRepository, ILotService lotService) {
        this.equipementRepository = equipementRepository;
        this.lotService = lotService;
    }

    @Override
    public EquipementResponseDto addEquipement(EquipementRequestDto requestDto) {
        Equipement equipement=new Equipement();
        equipement.setNumeroSerie(requestDto.getNumeroSerie());
        Lot lot=lotService.getLotById(requestDto.getLotId());
        equipement.setLot(lot);
//      System.out.println("equipement = " + equipement);
//        equipement.setNumeroUnique(EquipmentCodeGenerator.generateEquipmentCode(lot.getProvider().getNom(),lot.getTypeEquipement().getAbreviation(),lot.getDateLivraison()));
        System.out.println("equipement = " + equipement);
        return Mapper.equipementtoEquipementResponseDto(equipementRepository.save(equipement),lotService);
    }

    @Override
    public List<Equipement> addListOfEquipements(List<EquipementResponseDto> equipements) {
        return null;
    }

    @Override
    public EquipementResponseDto getEquipement(Long id) {
        Equipement equipement= equipementRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(""));
        return Mapper.equipementtoEquipementResponseDto(equipement,lotService);
    }

    @Override
    public Optional<Equipement> getEquipementByLot(Long id) {
        return Optional.empty();
    }

    @Override
    public List<EquipementResponseDto> getEquipementsFromLot(Long idLot) {
        List<Equipement> equipements=equipementRepository.findByLotId(idLot);
        return equipements.stream().map(equipement -> Mapper.equipementtoEquipementResponseDto(equipement,lotService)).toList();
    }

    @Override
    public List<EquipementResponseDto> getEquipementsEnStock() {
        List<Equipement> equipements=equipementRepository.findByCurrentPosition("en stock");
        return equipements.stream().map(equipement -> Mapper.equipementtoEquipementResponseDto(equipement,lotService)).toList();
    }

    @Override
    public List<EquipementResponseDto> getAllEquipements() {
        List<Equipement> equipements=equipementRepository.findAll();
        return equipements.stream().map(equipement -> Mapper.equipementtoEquipementResponseDto(equipement,lotService)).toList();
    }
}
