package infra.service;

import infra.dto.request.SubdivisionRequestDto;
import infra.dto.response.SubdivisionResponseDto;
import infra.enums.TypeSubdivision;
import infra.exception.ResourceNotFoundException;
import infra.model.Subdivision;

import java.util.List;

public interface ISubdivisionService {
    SubdivisionResponseDto addSubdivision(SubdivisionRequestDto subdivisionRequestDto);

    SubdivisionResponseDto addSubdivisionWithParent(SubdivisionRequestDto dto) throws ResourceNotFoundException;

    Subdivision getSubdivision(Long id);

    Subdivision getSubdivisionByName(String name);

    List<SubdivisionResponseDto> getSubdivisionByNameContaining(String name);

    List<SubdivisionResponseDto> getSubdivisionParentId(Long id);

    List<SubdivisionResponseDto> getSubdivisionByTypeAndParentId(TypeSubdivision type, Long id);

    List<SubdivisionResponseDto> getAllSubdivisions();

    void deleteSubdivision(Long id);

    SubdivisionResponseDto rattacherParent(Long id, Long idParent);
}
