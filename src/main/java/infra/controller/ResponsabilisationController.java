package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.ResponsabilisationRequestDto;
import infra.dto.response.ResponsabilisationResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.service.ResponsabilisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }
}
