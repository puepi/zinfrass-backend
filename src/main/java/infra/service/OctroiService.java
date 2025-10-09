package infra.service;

import infra.dto.Mapper;
import infra.dto.request.OctroiRequestDto;
import infra.dto.response.OctroiResponseDto;
import infra.model.Octroi;
import infra.repository.OctroiRepository;
import infra.repository.StructureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OctroiService implements IOctroiService {
    private final OctroiRepository octroiRepository;
    private final IStructureService structureService;
    private final ILotService lotService;
    @Override
    public OctroiResponseDto addOctroi(OctroiRequestDto requestDto) {
        Octroi octroi=new Octroi();
        octroi.setStructure(structureService.getStructure(requestDto.getStructureId()));
        octroi.setPoste(requestDto.getPoste());
        octroi.setLot(lotService.getLotById(requestDto.getLotId()));
        octroi.setNomsBénéficiaire(requestDto.getNomsBénéficiaire());
        octroi.setDateOctroi(requestDto.getDateOctroi());
        octroi.setReferenceDocument(requestDto.getReferenceDocument());
        return Mapper.octroiToOctroiResponseDto(octroiRepository.save(octroi));
    }

    @Override
    public List<OctroiResponseDto> getAllOctrois() {
        List<Octroi> responseDtos= octroiRepository.findAll();
        return responseDtos.stream()
                .map(octroi -> Mapper.octroiToOctroiResponseDto(octroi))
                .toList();
    }

    @Override
    public void deleteOctroi(Long id) {
        octroiRepository.deleteById(id);
    }
}
