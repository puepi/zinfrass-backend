package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.DemandeRequestDto;
import infra.dto.response.DemandeResponseDto;
import infra.dto.response.PosteResponseDto;
import infra.service.IDemandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/demandes")
@RequiredArgsConstructor
public class DemandeController {
    private final IDemandeService demandeService;

    @PostMapping("/add")
    ResponseEntity<ApiResponse> addDemande(@RequestBody DemandeRequestDto requestDto){
        try {
            DemandeResponseDto responseDto= demandeService.addDemande(requestDto);
            return ResponseEntity.ok(new ApiResponse("Succes",responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> getAllPostes(){
        try {
            List<DemandeResponseDto> responseDto=demandeService.getAllDemandes();
            return ResponseEntity.ok(new ApiResponse("Success", (responseDto)));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }
}
