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
        return Mapper.EquipementtoEquipementResponseDto(equipementRepository.save(equipement));
    }

    @Override
    public List<Equipement> addListOfEquipements(List<EquipementResponseDto> equipements) {
        return null;
    }

    @Override
    public EquipementResponseDto getEquipement(Long id) {
        Equipement equipement= equipementRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(""));
        return Mapper.EquipementtoEquipementResponseDto(equipement);
    }
}
