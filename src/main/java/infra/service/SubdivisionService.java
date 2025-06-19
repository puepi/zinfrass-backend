package infra.service;

import infra.dto.Mapper;
import infra.dto.request.SubdivisionRequestDto;
import infra.dto.response.SubdivisionResponseDto;
import infra.enums.TypeSubdivision;
import infra.exception.ResourceNotFoundException;
import infra.model.Subdivision;
import infra.repository.SubdivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubdivisionService implements ISubdivisionService {

    private final SubdivisionRepository subdivisionRepository;

    @Autowired
    public SubdivisionService(SubdivisionRepository subdivisionRepository) {
        this.subdivisionRepository = subdivisionRepository;
    }

    @Override
    public SubdivisionResponseDto addSubdivision(SubdivisionRequestDto dto) {
        Subdivision subdivision=new Subdivision();
        subdivision.setNom(dto.getNom());
        subdivision.setType(TypeSubdivision.fromString(dto.getType()));
        subdivision.setParent(null);
        return Mapper.subdivisionToSubdivisionResponseDto(subdivisionRepository.save(subdivision));
    }

    @Override
    public SubdivisionResponseDto addSubdivisionWithParent(SubdivisionRequestDto dto) throws ResourceNotFoundException {
        Subdivision subdivision=new Subdivision();
        subdivision.setNom(dto.getNom());
        Subdivision parent=getSubdivision(dto.getParentId());
        subdivision.setParent(parent);
        subdivision.setType(TypeSubdivision.fromString(dto.getType()));
        return Mapper.subdivisionToSubdivisionResponseDto(subdivisionRepository.save(subdivision));
    }

    @Override
    public Subdivision getSubdivision(Long id){
        return subdivisionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Subdivision inexistante"));
    }

    @Override
    public List<SubdivisionResponseDto> getAllSubdivisions() {
        List<Subdivision> subdivisions=subdivisionRepository.findAll();
        return Mapper.subdivisonsToListOfSubdivisionResponseDto(subdivisions);
    }

    @Override
    public void deleteSubdivision(Long id){
        Subdivision subdivision=getSubdivision(id);
        subdivisionRepository.deleteById(id);
    }

    @Override
    public SubdivisionResponseDto rattacherParent(Long id, Long idParent) throws ResourceNotFoundException{
        Subdivision subdivision=getSubdivision(id);
        Subdivision parent=getSubdivision(idParent);
        subdivision.setParent(parent);
        return Mapper.subdivisionToSubdivisionResponseDto(subdivisionRepository.save(subdivision));
    }
}
