package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.response.BatimentResponseDto;
import infra.dto.response.InventoryEquipementDto;
import infra.service.EquipementService;
import infra.service.ILotService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final EquipementService equipementService;

    @GetMapping("/equipements")
    public ResponseEntity<ApiResponse> getInventoryEquipement(){
        try {
            List<InventoryEquipementDto> responseDto=equipementService.getInventoryEquipement();
            return ResponseEntity.ok(new ApiResponse("Success", responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/equipements/getall/pagination")
    public ResponseEntity<ApiResponse> getInventoryAllPaginated(Pageable pageable){
        try {
            Page<InventoryEquipementDto> responseDto=equipementService.getInventoryAllPaginated(pageable);
            return ResponseEntity.ok(new ApiResponse("Success", responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }
}
