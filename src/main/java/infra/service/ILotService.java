package infra.service;

import infra.dto.request.EquipementRequestDto;
import infra.dto.request.LotRequestDto;
import infra.dto.response.LotResponseDto;
import infra.model.Lot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILotService {
    LotResponseDto addLot(LotRequestDto request);

    Lot getLotById(Long lotId);

    List<LotResponseDto> getAllLots();
    Page<LotResponseDto> getPaginatedAllLots(Pageable pageable);

    String genererNroLot(Lot lot);

    LotResponseDto changeQuantity(Long idLot, int qty);

    void deleteLot(Long idLot);

    LotResponseDto addEquipementsToLot(Long idLot, List<EquipementRequestDto> equipements);
}
