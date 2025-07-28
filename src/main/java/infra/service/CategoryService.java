package infra.service;

import infra.dto.Mapper;
import infra.dto.request.CategorieRequestDto;
import infra.dto.response.CategorieResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.model.Categorie;
import infra.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategorieResponseDto addCategorie(CategorieRequestDto dto) {
        Categorie categorie=new Categorie();
        categorie.setNom(dto.getNom());
        return Mapper.categorieToCategorieResponseDto(categoryRepository.save(categorie));
    }


    @Override
    public Categorie getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Category does not exists"));

    }

    @Override
    public List<CategorieResponseDto> getAllCategories() {
        List<Categorie> categories=categoryRepository.findAll();
        return Mapper.categoriesToListOfCategorieResponseDto(categories);
    }

    @Override
    public List<Categorie> getCategories() {
        return categoryRepository.findAll();
    }
}
