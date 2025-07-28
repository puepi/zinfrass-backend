package infra.service;

import infra.dto.request.CategorieRequestDto;
import infra.dto.response.CategorieResponseDto;
import infra.model.Categorie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    public CategorieResponseDto addCategorie(CategorieRequestDto dto);
    public Categorie getCategory(Long id);
    public List<Categorie> getCategories();

    List<CategorieResponseDto> getAllCategories();
}
