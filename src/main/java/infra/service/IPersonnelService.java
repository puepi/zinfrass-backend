package infra.service;

import infra.dto.request.PersonnelRequestDto;
import infra.dto.response.PersonnelResponseDto;
import infra.model.Personnel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonnelService {
    public PersonnelResponseDto addPersonnel(PersonnelRequestDto requestDto);
    public List<PersonnelResponseDto> getAllPersonnels();
    public PersonnelResponseDto getPersonnelByMatricule(String matricule);
    Page<PersonnelResponseDto> getPaginetedAllPersonnels(Pageable pageable);
    String getNoms(Long id);
}
