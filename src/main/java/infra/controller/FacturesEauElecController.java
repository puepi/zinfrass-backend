package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.FacturesEauElecRequestDto;
import infra.dto.response.FacturesEauElecResponseDto;
import infra.service.FacturesEauElecService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factures")
@RequiredArgsConstructor
public class FacturesEauElecController {
    private final FacturesEauElecService facturesEauElecService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addFactures(@RequestBody FacturesEauElecRequestDto requestDto){
        try {
            FacturesEauElecResponseDto responseDto=facturesEauElecService.addFacturesEauElec(requestDto);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> getAllFactures(){
        try {
            List<FacturesEauElecResponseDto> responseDto=facturesEauElecService.getAllFactures();
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }
}
