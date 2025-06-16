package infra.controller;


import infra.api_response.ApiResponse;
import infra.dto.request.FournisseurRequestDto;
import infra.dto.response.FournisseurResponseDto;
import infra.model.Fournisseur;
import infra.service.IFournisseurService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
