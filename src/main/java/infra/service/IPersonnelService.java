package infra.service;

import infra.dto.request.PersonnelRequestDto;
import infra.dto.response.PersonnelResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonnelService {
    public PersonnelResponseDto addPersonnel(PersonnelRequestDto requestDto);
    public List<PersonnelResponseDto> getAllPersonnels();
    public PersonnelResponseDto getPersonnelByMatricule(String matricule);
    String getNoms(Long id);
}
