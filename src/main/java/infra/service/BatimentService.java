package infra.service;

import infra.dto.Mapper;
import infra.dto.request.BatimentRequestDto;
import infra.dto.request.BatimentResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.model.Batiment;
import infra.model.Subdivision;
import infra.repository.BatimentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BatimentService implements IBatimentService{

    private final BatimentRepository batimentRepository;
    private final ISubdivisionService subdivisionService;
    @Override
    public BatimentResponseDto addBatiment(BatimentRequestDto batimentRequestDto) {
        Batiment batiment=new Batiment();
        batiment.setNom(batimentRequestDto.getNom());
        batiment.setNature(batimentRequestDto.getNature());
        Subdivision subdivision=subdivisionService.getSubdivisionByName(batimentRequestDto.getSubdivisionName());
        batiment.setSubdivision(subdivision);
        return Mapper.batimentToBatimentResponseDto(batimentRepository.save(batiment));
    }

    @Override
    public Batiment getBatiment(Long id) {
        Batiment batiment=batimentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("batiment inexistant"));
        return batiment;
    }
}
