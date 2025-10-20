package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.IncidentRequestDto;
import infra.dto.response.IncidentResponseDto;
import infra.service.IIncidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incidents")
@RequiredArgsConstructor
public class IncidentController {
    private final IIncidentService incidentService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addIncident(@RequestBody IncidentRequestDto requestDto){
        try {
            IncidentResponseDto responseDto=incidentService.addIncident(requestDto);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> getAllIncidents(){
        try {
            List<IncidentResponseDto> responseDto=incidentService.getAllIncidents();
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateIncidents(){
        try {
            return ResponseEntity.ok(new ApiResponse("Success",null));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }
}
