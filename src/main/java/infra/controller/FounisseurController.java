package infra.controller;


import infra.api_response.ApiResponse;
import infra.dto.request.FournisseurRequestDto;
import infra.dto.response.FournisseurResponseDto;
import infra.model.Fournisseur;
import infra.service.IFournisseurService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseurs")
public class FounisseurController {
    private final IFournisseurService fournisseurService;

    public FounisseurController(IFournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addFournisseur(@RequestBody FournisseurRequestDto request){
        try {
            FournisseurResponseDto responseDto=fournisseurService.addFournisseur(request);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Failure",null));
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> getFournisseurs(){
        try {
            List<FournisseurResponseDto> responseDto=fournisseurService.getFournisseurs();
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }
}
