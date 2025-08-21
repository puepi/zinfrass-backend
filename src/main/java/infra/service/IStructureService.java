package infra.service;

import infra.dto.request.StructureRequestDto;
import infra.dto.response.StructureResponseDto;
import infra.model.Structure;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStructureService {
    StructureResponseDto addStructure(StructureRequestDto structure);

    StructureResponseDto rattacherParent(Long id, Long idParent);

    Structure getStructure(Long id);

    List<StructureResponseDto> geAllStructures();

    List<StructureResponseDto> getStructureByNameContaining(String name);
}
