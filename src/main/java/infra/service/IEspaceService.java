package infra.service;

import infra.dto.request.EspaceRequestDto;
import infra.dto.response.EspaceResponseDto;

import java.util.List;

public interface IEspaceService {
    EspaceResponseDto addEspace(EspaceRequestDto requestDto);

    List<EspaceResponseDto> getAllEspaces();

    List<EspaceResponseDto> getAllEspace();
}
