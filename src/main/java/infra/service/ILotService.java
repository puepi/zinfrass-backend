package infra.service;

import infra.dto.request.LotRequestDto;
import infra.dto.response.LotResponseDto;
import infra.model.Lot;

public interface ILotService {
    LotResponseDto addLot(LotRequestDto request);

    Lot getLotById(Long lotId);
}
