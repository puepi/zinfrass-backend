package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.CategorieRequestDto;
import infra.dto.response.CategorieResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.model.Categorie;
import infra.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            CategorieResponseDto response=categoryService.addCategorie(request);
            return ResponseEntity.ok(new ApiResponse("Success",response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Failure",null));
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getCategorie(@PathVariable Long id){
        try {
            Categorie response=categoryService.getCategory(id);
            return ResponseEntity.ok(new ApiResponse("Found",response));
        }catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Failure",null));
        }
    }
}
