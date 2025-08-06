package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.TypeEquipementRequestDto;
import infra.dto.response.TypeEquipementResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.service.ITypeEquipementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> getAllTypesEquipement(){
        try {
            List<TypeEquipementResponseDto> response=typeEquipementService.getAllTypesEquipement();
            System.out.println("response = " + response);
            return ResponseEntity.ok(new ApiResponse("Success",response));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getTypeEquipement(@PathVariable Long id){
        try {
            TypeEquipementResponseDto responseDto=typeEquipementService.getTypeEquipement(id);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }
}
