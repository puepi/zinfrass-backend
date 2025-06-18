package infra.service;

import infra.dto.request.SubdivisionRequestDto;
import infra.dto.response.SubdivisionResponseDto;
import infra.model.Subdivision;

public interface ISubdivisionService {
    SubdivisionResponseDto addSubdivision(SubdivisionRequestDto subdivisionRequestDto);

    Subdivision getSubdivision(Long id);


    SubdivisionResponseDto rattacherParent(Long id, Long idParent);
}
