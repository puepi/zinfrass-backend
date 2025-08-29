package infra.service;

import infra.dto.Mapper;
import infra.dto.request.PersonnelRequestDto;
import infra.dto.response.PersonnelResponseDto;
import infra.model.Personnel;
import infra.repository.PersonnelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
