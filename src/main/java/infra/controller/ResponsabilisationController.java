package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.Mapper;
import infra.dto.request.ResponsabilisationRequestDto;
import infra.dto.response.ResponsabilisationResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.model.Responsabilisation;
import infra.service.ResponsabilisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsabilisations")
public class ResponsabilisationController {
    private final ResponsabilisationService responsabilisationService;

    @Autowired
    public ResponsabilisationController(ResponsabilisationService responsabilisationService) {
        this.responsabilisationService = responsabilisationService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addResponsabilisation(@RequestBody ResponsabilisationRequestDto requestDto){
        try {
            ResponsabilisationResponseDto responseDto=responsabilisationService.addResponsabilisation(requestDto);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch(ResourceNotFoundException e){
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/get/{structureId}/{posteId}")
    public ResponseEntity<ApiResponse> getResponsabilisation(@PathVariable Long structureId,@PathVariable Long posteId){
        try {
            Responsabilisation responseDto=responsabilisationService.getResponsabilisation(structureId,posteId);
            return ResponseEntity.ok(new ApiResponse("Found", Mapper.responsabilisationToResponsabilisationResponseDto(responseDto)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> getResponsabilisations(){
        try {
            List<ResponsabilisationResponseDto> responseDto=responsabilisationService.getResponsabilisations();
            return ResponseEntity.ok(new ApiResponse("Found", (responseDto)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }
}
