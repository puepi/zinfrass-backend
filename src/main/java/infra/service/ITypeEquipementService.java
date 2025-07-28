package infra.service;

import infra.dto.request.TypeEquipementRequestDto;
import infra.dto.response.TypeEquipementResponseDto;
import infra.model.TypeEquipement;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface ITypeEquipementService {
    public TypeEquipementResponseDto addTypeEquipement(@RequestBody TypeEquipementRequestDto dto);
    public TypeEquipement get(Long id);

    List<TypeEquipementResponseDto> getAllTypesEquipement();
}
