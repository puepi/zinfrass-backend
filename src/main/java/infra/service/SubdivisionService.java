package infra.service;

import infra.dto.Mapper;
import infra.dto.request.SubdivisionRequestDto;
import infra.dto.response.SubdivisionResponseDto;
import infra.enums.TypeSubdivision;
import infra.exception.ResourceNotFoundException;
import infra.model.Subdivision;
import infra.repository.SubdivisionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubdivisionService implements ISubdivisionService {

    private final SubdivisionRepository subdivisionRepository;


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
        Subdivision parent=null;
        if(dto.getParentId()!= null){
            parent=getSubdivision(dto.getParentId());
            subdivision.setParent(parent);
        }
        subdivision.setType(TypeSubdivision.fromString(dto.getType()));
        return Mapper.subdivisionToSubdivisionResponseDto(subdivisionRepository.save(subdivision));
    }

    @Override
    public Subdivision getSubdivision(Long id){
        return subdivisionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Subdivision inexistante"));
    }

    @Override
    public Subdivision getSubdivisionByName(String name){
        return subdivisionRepository.findByNomIgnoreCase(name).orElseThrow(()->new ResourceNotFoundException("Subdivision inexistante"));
    }

    @Override
    public List<SubdivisionResponseDto> getSubdivisionByNameContaining(String name) {
        List<Subdivision> subdivisions=subdivisionRepository.findByNomContainingIgnoreCase(name);
        return Mapper.subdivisonsToListOfSubdivisionResponseDto(subdivisions);
    }

    @Override
    public List<SubdivisionResponseDto> getSubdivisionParentId(Long id){
        List<Subdivision> subdivisions=subdivisionRepository.findByParentId(id);
        List<Subdivision> sub=subdivisions.stream().filter(s->s.getId()!=s.getParent().getId()).toList();
        return Mapper.subdivisonsToListOfSubdivisionResponseDto(sub);
    }

    @Override
    public List<SubdivisionResponseDto> getSubdivisionByTypeAndParentId(TypeSubdivision type,Long id){
        List<Subdivision> subdivisions=subdivisionRepository.findByTypeAndParentId(type,id);
        return Mapper.subdivisonsToListOfSubdivisionResponseDto(subdivisions);
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
