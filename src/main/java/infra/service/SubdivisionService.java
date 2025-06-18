package infra.service;

import infra.dto.Mapper;
import infra.dto.request.SubdivisionRequestDto;
import infra.dto.response.SubdivisionResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.model.Subdivision;
import infra.repository.SubdivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubdivisionService implements ISubdivisionService {

    private final SubdivisionRepository subdivisionRepository;

    @Autowired
    public SubdivisionService(SubdivisionRepository subdivisionRepository) {
        this.subdivisionRepository = subdivisionRepository;
    }

    @Override
    public SubdivisionResponseDto addSubdivision(SubdivisionRequestDto dto) throws ResourceNotFoundException {
        Subdivision subdivision=new Subdivision();
        subdivision.setNom(dto.getNom());
        if(dto.getParentId()!=null)
            subdivision.setParent(getSubdivision(dto.getParentId()));
        return Mapper.subdivisionToSubdivisionResponseDto(subdivisionRepository.save(subdivision));
    }

    @Override
    public Subdivision getSubdivision(Long id){
        return subdivisionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Subdivision inexistante"));
    }

    @Override
    public SubdivisionResponseDto rattacherParent(Long id, Long idParent){
        Subdivision subdivision=getSubdivision(id);
        Subdivision parent=getSubdivision(idParent);
        subdivision.setParent(parent);
        return Mapper.subdivisionToSubdivisionResponseDto(subdivisionRepository.save(subdivision));
    }
}
