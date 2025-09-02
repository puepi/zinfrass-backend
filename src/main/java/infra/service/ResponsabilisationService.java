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
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    @Transactional
    public ResponsabilisationResponseDto addResponsabilisation(ResponsabilisationRequestDto requestDto) throws ResourceNotFoundException {
        Responsabilisation responsabilisation=new Responsabilisation();
        Optional<Responsabilisation> existingRespo=responsabilisationRepository.findByStructureIdAndPosteIdAndActifTrue(requestDto.getStructureId(), requestDto.getPosteId());
        if(existingRespo.isPresent()){
            Responsabilisation theRepo=existingRespo.get();
            Structure structure=structureService.getStructure(requestDto.getStructureId());
            Poste poste=posteService.getPoste(requestDto.getPosteId());
            theRepo.setStructure(structure);
            theRepo.setPoste(poste);
            theRepo.setDebut(requestDto.getDebut());
            theRepo.setFin(requestDto.getFin());
            theRepo.setNomsPrenoms(requestDto.getNoms());
            if(!theRepo.getNomsPrenoms().trim().equalsIgnoreCase("Poste vacant")){
                theRepo.setActif(false);
            }else{
                theRepo.setActif(requestDto.getActif());
            }
            return Mapper.responsabilisationToResponsabilisationResponseDto(responsabilisationRepository.save(theRepo));
        }else{
            Structure structure=structureService.getStructure(requestDto.getStructureId());
            Poste poste=posteService.getPoste(requestDto.getPosteId());
            responsabilisation.setStructure(structure);
            responsabilisation.setPoste(poste);
            responsabilisation.setDebut(requestDto.getDebut());
            responsabilisation.setFin(requestDto.getFin());
            responsabilisation.setNomsPrenoms(requestDto.getNoms());
            responsabilisation.setActif(requestDto.getActif());
            return Mapper.responsabilisationToResponsabilisationResponseDto(responsabilisationRepository.save(responsabilisation));
        }
//        responsabilisation.setId(new ResponsabilisationId(requestDto.getStructureId(), requestDto.getPosteId()));
//        System.out.println("respo= " + new ResponsabilisationId(requestDto.getStructureId(), requestDto.getPosteId()));
    }

    @Override
    public Responsabilisation getResponsabilisation(Long structureId, Long posteId){
        ResponsabilisationId id=new ResponsabilisationId(structureId,posteId);
        return responsabilisationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Responsabilisation not found"));
    }

    @Override
    public List<ResponsabilisationResponseDto> getResponsabilisations(){
        List<Responsabilisation> responseDtos=responsabilisationRepository.findAllByActifTrue();
        return Mapper.responsabilisationsToListOfResponsabilisationResponseDto(responseDtos);
    }

}
