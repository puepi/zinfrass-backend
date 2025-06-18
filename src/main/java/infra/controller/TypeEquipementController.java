package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.TypeEquipementRequestDto;
import infra.dto.response.TypeEquipementResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.service.ITypeEquipementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/types-equipement")
public class TypeEquipementController {
    private final ITypeEquipementService typeEquipementService;

    public TypeEquipementController(ITypeEquipementService typeEquipementService) {
        this.typeEquipementService = typeEquipementService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addTypeEquipement(@RequestBody TypeEquipementRequestDto dto){
        try {
            TypeEquipementResponseDto response=typeEquipementService.addTypeEquipement(dto);
            return ResponseEntity.ok(new ApiResponse("Success",response));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
