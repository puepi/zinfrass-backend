package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.Mapper;
import infra.dto.request.BatimentRequestDto;
import infra.dto.request.BatimentResponseDto;
import infra.model.Batiment;
import infra.service.IBatimentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batiments")
@RequiredArgsConstructor
public class BatimentController {
    private final IBatimentService batimentService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addBatiment(@RequestBody BatimentRequestDto requestDto){
        try {
            BatimentResponseDto responseDto=batimentService.addBatiment(requestDto);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getBatiment(@PathVariable Long id){
        try {
            Batiment responseDto=batimentService.getBatiment(id);
            return ResponseEntity.ok(new ApiResponse("Success", Mapper.batimentToBatimentResponseDto(responseDto)));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/subdivision/{id}")
    public ResponseEntity<ApiResponse> getBatimentBySubdivision(@PathVariable Long id){
        try {
            List<BatimentResponseDto> responseDto=batimentService.getBatimentBySubdivision(id);
            return ResponseEntity.ok(new ApiResponse("Success", responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }

    }
    @GetMapping("/subdivision-name")
    public ResponseEntity<ApiResponse> getBatimentBySubdivisionName(@RequestParam String name){
        try {
            List<BatimentResponseDto> responseDto=batimentService.getBatimentBySubdivisionName(name);
            return ResponseEntity.ok(new ApiResponse("Success", responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }

    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> getAllBatiments(){
        try {
            List<BatimentResponseDto> responseDto=batimentService.getBatiments();
            return ResponseEntity.ok(new ApiResponse("Success", responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }

    }
}
