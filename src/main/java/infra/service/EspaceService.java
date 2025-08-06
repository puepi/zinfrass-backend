package infra.service;

import infra.dto.Mapper;
import infra.dto.request.EspaceRequestDto;
import infra.dto.response.EspaceResponseDto;
import infra.enums.Usage;
import infra.exception.ResourceAlreadyExistsException;
import infra.model.Espace;
import infra.repository.EspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EspaceService implements IEspaceService{
    private final EspaceRepository espaceRepository;
    private final IBatimentService batimentService;
    @Override
    public EspaceResponseDto addEspace(EspaceRequestDto requestDto) throws ResourceAlreadyExistsException {
        Espace espace=new Espace();
        espace.setNom(requestDto.getNom());
        espace.setPosition(requestDto.getPosition());
        espace.setUsages(Usage.valueOf(requestDto.getUsage()));
        espace.setBatiment(batimentService.getBatiment(requestDto.getBatimentId()));
        espace.setDimensions(requestDto.getDimensions());
        return Mapper.espaceToEspaceResponseDto(espace);
    }

    @Override
    public List<EspaceResponseDto> getAllEspaces() {
        return List.of();
    }
}
