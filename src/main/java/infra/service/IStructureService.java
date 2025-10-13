package infra.service;

import infra.dto.request.StructureRequestDto;
import infra.dto.response.StructureResponseDto;
import infra.model.Structure;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStructureService {
    StructureResponseDto addStructure(StructureRequestDto structure);

    StructureResponseDto rattacherParent(Long id, Long idParent);

    Structure getStructure(Long id);

    List<StructureResponseDto> geAllStructures();

    Page<StructureResponseDto> getPaginatedAllStructures(Pageable pageable);

    List<StructureResponseDto> getStructureByNameContaining(String name);
}
