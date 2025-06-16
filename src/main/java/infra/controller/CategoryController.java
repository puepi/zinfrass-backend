package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.CategorieRequestDto;
import infra.dto.response.CategorieResponseDto;
import infra.model.Categorie;
import infra.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCategorie(@RequestBody CategorieRequestDto request){
        try {
            CategorieResponseDto categorie=categoryService.addCategorie(request);
            return ResponseEntity.ok(new ApiResponse("Succes",categorie));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Failure",null));
        }
    }
}
