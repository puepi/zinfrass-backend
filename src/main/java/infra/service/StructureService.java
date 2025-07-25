package infra.service;

import infra.dto.Mapper;
import infra.dto.request.StructureRequestDto;
import infra.dto.response.StructureResponseDto;
import infra.enums.TypeStructure;
import infra.exception.ResourceNotFoundException;
import infra.model.Structure;
import infra.repository.StructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StructureService implements IStructureService {
    private final StructureRepository structureRepository;
    private final SubdivisionService subdivisionService;

    @Autowired
    public StructureService(StructureRepository structureRepository, SubdivisionService service) {
        this.structureRepository = structureRepository;
        this.subdivisionService = service;
    }

    @Override
    public StructureResponseDto addStructure(StructureRequestDto requestDto) {
        Structure structure=new Structure();
        structure.setNom(requestDto.getNom());
        structure.setAbreviation(requestDto.getAbreviation());
        structure.setType(TypeStructure.fromString(requestDto.getType()));
        structure.setSubdivision(subdivisionService.getSubdivision(requestDto.getSubdivisionId()));
        if(requestDto.getParentId()!=null)
            structure.setParent(getStructure(requestDto.getParentId()));
        return Mapper.structureToStructureResponseDto(structureRepository.save(structure));
    }

    @Override
    public StructureResponseDto rattacherParent(Long id, Long idParent) {
        Structure responseDto=getStructure(id);
        Structure parent=getStructure(idParent);
        responseDto.setParent(parent);
        return Mapper.structureToStructureResponseDto(structureRepository.save(responseDto));
    }

    @Override
    public Structure getStructure(Long id) {
        Structure structure=structureRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Structure inexistante"));
        return structure;
    }

    @Override
    public List<StructureResponseDto> geAllStructures() {
        List<Structure> structures=structureRepository.findAll();
        return Mapper.structuresToListOfStructureResponseDto(structures);
    }
}
