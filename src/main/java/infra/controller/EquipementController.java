package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.EquipementRequestDto;
import infra.dto.response.EquipementResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.service.EquipementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipements")
public class EquipementController {
    private final EquipementService equipementService;

    public EquipementController(EquipementService equipementService) {
        this.equipementService = equipementService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addEquipement(@RequestBody EquipementRequestDto request){
        try {
            EquipementResponseDto responseDto=equipementService.addEquipement(request);
            return ResponseEntity.ok(new ApiResponse("Succes",responseDto));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Failure",null));
        }
    }

    @PostMapping("/getAll")
    public ResponseEntity<ApiResponse> getAllEquipements(){
        try {
            List<EquipementResponseDto> responseDto=equipementService.getAllEquipements();
            return ResponseEntity.ok(new ApiResponse("Succes",responseDto));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Failure",null));
        }
    }

    @GetMapping("/get/{idLot}")
    public ResponseEntity<ApiResponse> getAllEquipements(@PathVariable Long idLot){
        try {
            List<EquipementResponseDto> responseDto=equipementService.getEquipementsFromLot(idLot);
            return ResponseEntity.ok(new ApiResponse("Succes",responseDto));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Failure",null));
        }
    }

    @GetMapping("/en-stock")
    public ResponseEntity<ApiResponse> getEquipementsEnStock(){
        try {
            List<EquipementResponseDto> responseDto=equipementService.getEquipementsEnStock();
            return ResponseEntity.ok(new ApiResponse("Succes",responseDto));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Failure",null));
        }
    }
}
