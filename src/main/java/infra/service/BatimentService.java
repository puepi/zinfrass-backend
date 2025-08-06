package infra.service;

import infra.dto.Mapper;
import infra.dto.request.BatimentRequestDto;
import infra.dto.response.BatimentResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.model.Batiment;
import infra.model.Subdivision;
import infra.repository.BatimentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        batiment.setDescription(batimentRequestDto.getDescription());
        batiment.setRetrocede(batimentRequestDto.isRetrocede());
        batiment.setDateRetrocession(batimentRequestDto.getDateRetrocession());
        Subdivision subdivision=subdivisionService.getSubdivision(batimentRequestDto.getSubdivisionId());
        batiment.setSubdivision(subdivision);
        return Mapper.batimentToBatimentResponseDto(batimentRepository.save(batiment));
    }

    @Override
    public Batiment getBatiment(Long id) {
        Batiment batiment=batimentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("batiment inexistant"));
        return batiment;
    }

    @Override
    public List<BatimentResponseDto> getBatimentBySubdivision(Long id) throws ResourceNotFoundException{
        Subdivision subdivision=subdivisionService.getSubdivision(id);
        List<Batiment> batiments=batimentRepository.findBySubdivisionId(id);
        return Mapper.batimentsToListOfBatimentResponseDto(batiments);
    }

    @Override
    public List<BatimentResponseDto> getBatimentBySubdivisionName(String name) {
        List<Batiment> batiments=batimentRepository.findBySubdivisionNomContainingIgnoreCase(name);
        return Mapper.batimentsToListOfBatimentResponseDto(batiments);
    }

    @Override
    public List<BatimentResponseDto> getBatiments() {
        List<Batiment> batiments=batimentRepository.findAll();
        return Mapper.batimentsToListOfBatimentResponseDto(batiments);
    }
}
