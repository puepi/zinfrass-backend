package infra.service;

import infra.dto.Mapper;
import infra.dto.request.TypeEquipementRequestDto;
import infra.dto.response.TypeEquipementResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.model.Categorie;
import infra.model.TypeEquipement;
import infra.repository.TypeEquipementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeEquipementService implements ITypeEquipementService{
    private final TypeEquipementRepository typeEquipementRepository;
    private  final ICategoryService categoryService;

    @Autowired
    public TypeEquipementService(TypeEquipementRepository typeEquipementRepository, ICategoryService categoryService) {
        this.typeEquipementRepository = typeEquipementRepository;
        this.categoryService = categoryService;
    }

    @Override
    public TypeEquipementResponseDto addTypeEquipement(TypeEquipementRequestDto dto) {
        TypeEquipement  typeEquipement=new TypeEquipement();
        typeEquipement.setNom(dto.getNom());
        typeEquipement.setCaracteristiques(dto.getCaracteristiques());
        if(dto.getCategoryId()==null)
            throw new ResourceNotFoundException("Equipement should have a category");

        Categorie categorie=categoryService.getCategory(dto.getCategoryId());
//        System.out.println("categorie = " + "la catégorie");
        typeEquipement.setCategorie(categorie);

        return Mapper.typeEquipementToTypeEquipementResponseDto(typeEquipementRepository.save(typeEquipement));
    }

    @Override
    public TypeEquipement get(Long id) {
        TypeEquipement typeEquipement=typeEquipementRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Type d'équipement inexistant"));
        return typeEquipement;
    }
}
