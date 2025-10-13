package infra.service;

import infra.dto.Mapper;
import infra.dto.request.PersonnelRequestDto;
import infra.dto.response.PersonnelResponseDto;
import infra.enums.Genre;
import infra.model.Personnel;
import infra.repository.PersonnelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonnelService implements IPersonnelService {
    private final PersonnelRepository personnelRepository;

    @Override
    public PersonnelResponseDto addPersonnel(PersonnelRequestDto requestDto) {
        Personnel personnel=new Personnel();
        personnel.setNoms(requestDto.getNoms());
        personnel.setMatricule(requestDto.getMatricule());
        personnel.setPrenoms(requestDto.getPrenoms());
        personnel.setGenre(Genre.fromString(requestDto.getGenre()));
        return Mapper.personnelToPersonnelResponse(personnelRepository.save(personnel));
    }

    @Override
    public List<PersonnelResponseDto> getAllPersonnels() {
        List<Personnel> personnels=personnelRepository.findAll();
        return Mapper.personnelsToListOfPersonnelResponseDto(personnels);
    }

    @Override
    public PersonnelResponseDto getPersonnelByMatricule(String matricule) {
        return null;
    }

    @Override
    public Page<PersonnelResponseDto> getPaginetedAllPersonnels(Pageable pageable) {
        return personnelRepository.findAll(pageable).map(Mapper::personnelToPersonnelResponse);
    }

    @Override
    public String getNoms(Long id) {
        Optional<Personnel> personnelOptional=personnelRepository.findById(id);
        String noms="";
        if(personnelOptional.isPresent()){
            Personnel personnel=personnelOptional.get();
            if(personnel.getGenre().toString().equals("MASCULIN")){
                noms+="M. ";
            }else if(personnel.getGenre().toString().equals("FEMININ")){
                noms+="Mme ";
            }
            noms+= personnel.getNoms() + " " + personnel.getPrenoms();
            return noms;
        }
        return noms;
    }

}
