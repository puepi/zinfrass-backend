package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.InterventionRequestDto;
import infra.dto.response.IncidentResponseDto;
import infra.dto.response.InterventionResponseDto;
import infra.service.IInterventionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interventions")
@RequiredArgsConstructor
public class InterventionController {
    private final IInterventionService interventionService;

    @PostMapping("/add-lot-magasin")
    public ResponseEntity<ApiResponse> addLotToMagasin(@RequestBody InterventionRequestDto requestDto){
        try {
            List<InterventionResponseDto> responseDto=interventionService.addLot(requestDto);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> getAll(){
        try {
            List<InterventionResponseDto> responseDto=interventionService.getAllInterventions();
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/getall/pagination")
    public ResponseEntity<ApiResponse> getAll(Pageable pageable){
        try {
            Page<InterventionResponseDto> responseDto=interventionService.getPaginatedAllInterventions(pageable);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @PostMapping("/add-installation")
    public ResponseEntity<ApiResponse> addInstallation(@RequestBody InterventionRequestDto requestDto){
        try {
            InterventionResponseDto responseDto=interventionService.addInstallation(requestDto);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<ApiResponse> deleteIntervention(@PathVariable Long id){
        try {
            interventionService.deleteIntervention(id);
            return ResponseEntity.ok(new ApiResponse("Success",null));
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }
}
