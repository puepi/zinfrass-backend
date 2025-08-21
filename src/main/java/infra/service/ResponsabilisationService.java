package infra.service;

import infra.dto.Mapper;
import infra.dto.request.ResponsabilisationRequestDto;
import infra.dto.response.ResponsabilisationResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.model.Poste;
import infra.model.Responsabilisation;
import infra.model.ResponsabilisationId;
import infra.model.Structure;
import infra.repository.ResponsabilisationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsabilisationService implements IResponsabilisationService {
    private final ResponsabilisationRepository responsabilisationRepository;
    private final StructureService structureService;
    private final PosteService posteService;

    public ResponsabilisationService(ResponsabilisationRepository responsabilisationRepository, StructureService structureService, PosteService posteService) {
        this.responsabilisationRepository = responsabilisationRepository;
        this.structureService = structureService;
        this.posteService = posteService;
    }

    @Override
    public ResponsabilisationResponseDto addResponsabilisation(ResponsabilisationRequestDto requestDto) throws ResourceNotFoundException {
        Responsabilisation responsabilisation=new Responsabilisation();
        Structure structure=structureService.getStructure(requestDto.getStructureId());
        Poste poste=posteService.getPoste(requestDto.getPosteId());
        responsabilisation.setStructure(structure);
        responsabilisation.setPoste(poste);
        responsabilisation.setDebut(requestDto.getDebut());
        responsabilisation.setFin(requestDto.getFin());
        responsabilisation.setNomsPrenoms(requestDto.getNoms());
        responsabilisation.setActif(requestDto.isActif());
//        responsabilisation.setId(new ResponsabilisationId(requestDto.getStructureId(), requestDto.getPosteId()));
//        System.out.println("respo= " + new ResponsabilisationId(requestDto.getStructureId(), requestDto.getPosteId()));
        return Mapper.responsabilisationToResponsabilisationResponseDto(responsabilisationRepository.save(responsabilisation));
    }

    @Override
    public Responsabilisation getResponsabilisation(Long structureId, Long posteId){
        ResponsabilisationId id=new ResponsabilisationId(structureId,posteId);
        return responsabilisationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Responsabilisation not found"));
    }

    @Override
    public List<ResponsabilisationResponseDto> getResponsabilisations(){
        List<Responsabilisation> responseDtos=responsabilisationRepository.findAll();
        return Mapper.responsabilisationsToListOfResponsabilisationResponseDto(responseDtos);
    }

}
