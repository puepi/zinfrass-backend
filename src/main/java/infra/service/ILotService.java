package infra.service;

import infra.dto.request.LotRequestDto;
import infra.dto.response.LotResponseDto;

public interface ILotService {
    public LotResponseDto addLot(LotRequestDto request);
}
