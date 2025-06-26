package infra.controller;

import infra.api_response.ApiResponse;
import infra.model.Logiciel;
import infra.service.LogicielService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logiciels")
@RequiredArgsConstructor
public class LogicielController {
    public final LogicielService logicielService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addLogiciel(@RequestBody Logiciel logiciel){
        try {
            Logiciel response=logicielService.addLogiciel(logiciel);
            return ResponseEntity.ok(new ApiResponse("Success",response));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }
}
