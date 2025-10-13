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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        // Vérifie s’il existe déjà une responsabilisation active pour ce poste et cette structure
        Optional<Responsabilisation> existingRespo = responsabilisationRepository
                .findByStructureIdAndPosteIdAndActifTrue(requestDto.getStructureId(), requestDto.getPosteId());

        Structure structure = structureService.getStructure(requestDto.getStructureId());
        Poste poste = posteService.getPoste(requestDto.getPosteId());

        if (existingRespo.isPresent()) {
            // Si une responsabilisation active existe déjà → on la désactive
            Responsabilisation oldRespo = existingRespo.get();
            oldRespo.setActif(false);
            responsabilisationRepository.save(oldRespo);
        }
        Responsabilisation theRepo = new Responsabilisation();
        theRepo.setStructure(structure);
        theRepo.setPoste(poste);
        theRepo.setDebut(requestDto.getDebut());
        theRepo.setFin(requestDto.getFin());

        // noms = "Poste vacant" si non renseigné
        String noms = requestDto.getNoms();
        if (noms == null || noms.trim().isEmpty()) {
            theRepo.setNomsPrenoms("Poste vacant");
        } else {
            theRepo.setNomsPrenoms(noms.trim());
        }

        // actif = true si non vacant
//            if (!theRepo.getNomsPrenoms().equalsIgnoreCase("Poste vacant")) {
        theRepo.setActif(true);
//            } else {
//                theRepo.setActif(false);
//            }

        return Mapper.responsabilisationToResponsabilisationResponseDto(responsabilisationRepository.save(theRepo));

//        } else {
//            Responsabilisation responsabilisation = new Responsabilisation();
//            responsabilisation.setStructure(structure);
//            responsabilisation.setPoste(poste);
//            responsabilisation.setDebut(requestDto.getDebut());
//            responsabilisation.setFin(requestDto.getFin());
//
//            // noms = "Poste vacant" si non renseigné
//            String noms = requestDto.getNoms();
//            if (noms == null || noms.trim().isEmpty()) {
//                responsabilisation.setNomsPrenoms("Poste vacant");
//            } else {
//                responsabilisation.setNomsPrenoms(noms.trim());
//            }
//
//            // actif = true si non vacant
////            if (!responsabilisation.getNomsPrenoms().equalsIgnoreCase("Poste vacant")) {
//                responsabilisation.setActif(true);
////            } else {
////                responsabilisation.setActif(false);
////            }

//            return Mapper.responsabilisationToResponsabilisationResponseDto(responsabilisationRepository.save(responsabilisation))
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

    @Override
    public Page<ResponsabilisationResponseDto> getPaginatedAllResponsabilisations(Pageable pageable) {
        return responsabilisationRepository.findAllByActifTrue(pageable).map(Mapper::responsabilisationToResponsabilisationResponseDto);
    }

}
