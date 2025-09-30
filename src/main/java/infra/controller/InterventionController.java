package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.InterventionRequestDto;
import infra.dto.response.IncidentResponseDto;
import infra.dto.response.InterventionResponseDto;
import infra.service.IInterventionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/interventions")
@RequiredArgsConstructor
public class InterventionController {
    private final IInterventionService interventionService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> add(@RequestBody InterventionRequestDto requestDto){
        try {
            List<InterventionResponseDto> responseDto=interventionService.addLot(requestDto);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }
}
