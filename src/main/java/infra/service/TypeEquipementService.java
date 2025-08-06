package infra.service;

import infra.dto.Mapper;
import infra.dto.request.TypeEquipementRequestDto;
import infra.dto.response.TypeEquipementResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.model.Categorie;
import infra.model.TypeEquipement;
import infra.repository.TypeEquipementRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeEquipementService implements ITypeEquipementService{
    private final TypeEquipementRepository typeEquipementRepository;
    private  final ICategoryService categoryService;

    @Autowired
    public TypeEquipementService(TypeEquipementRepository typeEquipementRepository, ICategoryService categoryService) {
        this.typeEquipementRepository = typeEquipementRepository;
        this.categoryService = categoryService;
    }

    @Transactional
    @Override
    public TypeEquipementResponseDto addTypeEquipement(TypeEquipementRequestDto dto) {
        TypeEquipement  typeEquipement=new TypeEquipement();
        typeEquipement.setNom(dto.getNom());
        typeEquipement.setCaracteristiques(dto.getCaracteristiques());
        typeEquipement.setAbreviation(dto.getAbreviation());
        if(dto.getCategoryId()==null)
            throw new ResourceNotFoundException("Equipement should have a category");

        Categorie categorie=categoryService.getCategory(dto.getCategoryId());
        typeEquipement.setCategorie(categorie);

        return Mapper.typeEquipementToTypeEquipementResponseDto(typeEquipementRepository.save(typeEquipement));
    }

    @Override
    public TypeEquipement get(Long id) {
        TypeEquipement typeEquipement=typeEquipementRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Type d'équipement inexistant"));
        return typeEquipement;
    }

    @Override
    public List<TypeEquipementResponseDto> getAllTypesEquipement() {
        List<TypeEquipement> typeEquipements=typeEquipementRepository.findAll();
        return Mapper.typesEquipementToListOfTypeEquipementResponseDto((typeEquipements));
    }

    @Override
    public TypeEquipementResponseDto getTypeEquipement(Long id) {
        TypeEquipement equipement= typeEquipementRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Type d'équipement doesn't exist"));
        return Mapper.typeEquipementToTypeEquipementResponseDto(equipement);
    }
}
