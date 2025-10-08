package infra.service;

import infra.dto.request.EquipementRequestDto;
import infra.dto.response.EquipementResponseDto;
import infra.model.Equipement;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IEquipementService {
    EquipementResponseDto addEquipement(EquipementRequestDto requestDto);
    List<Equipement> addListOfEquipements(List<EquipementResponseDto> equipements);
    EquipementResponseDto getEquipement(Long id);

    List<EquipementResponseDto> getEquipementsFromLot(Long idLot);
    List<EquipementResponseDto> getEquipementsEnStock();
    List<EquipementResponseDto> getAllEquipements();
}
