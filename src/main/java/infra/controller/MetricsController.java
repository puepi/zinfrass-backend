package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.response.PersonnelResponseDto;
import infra.repository.EquipementRepository;
import infra.repository.FacturesEauElecRepository;
import infra.repository.IncidentRepository;
import infra.repository.InterventionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/metrics")
@RequiredArgsConstructor
public class MetricsController {
    private final IncidentRepository incidentRepository;
    private final InterventionRepository interventionRepository;
    private final EquipementRepository equipementRepository;
    private final FacturesEauElecRepository seuilRepository;

    @GetMapping("/incidents/unresolved/count")
    public ResponseEntity<ApiResponse> unresolvedIncidents(){
        try {
            Long responseDto=incidentRepository.countUnresolvedIncidents();
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/interventions/count")
    public ResponseEntity<ApiResponse> countInterventions(){
        try {
            Long responseDto=interventionRepository.countAllInterventions();
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/stock/count")
    public ResponseEntity<ApiResponse> countStock(){
        try {
            Long responseDto=equipementRepository.countEquipementsEnStock();
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> getAll(){
        try {
            Map<String,Long> responseDto=new HashMap<>();
            responseDto.put("incidents", incidentRepository.countByResolu("non"));
            responseDto.put("interventions", interventionRepository.countAllInterventions());
            responseDto.put("stock", equipementRepository.countEquipementsEnStock());
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }
}
