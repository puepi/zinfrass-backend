package infra.service;

import infra.dto.Mapper;
import infra.dto.request.PosteRequestDto;
import infra.dto.response.PosteResponseDto;
import infra.enums.Rang;
import infra.exception.ResourceNotFoundException;
import infra.model.Poste;
import infra.repository.PosteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosteService implements IPosteService {

    private final PosteRepository posteRepository;

    public PosteService(PosteRepository posteRepository) {
        this.posteRepository = posteRepository;
    }

    @Override
    public PosteResponseDto addPoste(PosteRequestDto requestDto) {
        Poste poste=new Poste();
        poste.setNom(requestDto.getNom());
        poste.setRang(Rang.fromString(requestDto.getRang()));
        poste.setAbreviation(requestDto.getAbreviation());
        return Mapper.posteToPosteResponseDto(posteRepository.save(poste));
    }

    @Override
    public Poste getPoste(Long id) {
        return posteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Poste not found"));
    }

    @Override
    public List<PosteResponseDto> getAllPostes(){
        List<Poste> postes=posteRepository.findAll();
        return  Mapper.postesToListOfPosteResponseDto(postes);
    }

    @Override
    public Page<PosteResponseDto> getPaginatedAllPostes(Pageable pageable) {
        return posteRepository.findAll(pageable).map(Mapper::posteToPosteResponseDto);
    }

}
