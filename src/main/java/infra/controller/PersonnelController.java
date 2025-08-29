package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.PersonnelRequestDto;
import infra.dto.response.PersonnelResponseDto;
import infra.service.IPersonnelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/personnels")
@RequiredArgsConstructor
public class PersonnelController {
    private final IPersonnelService personnelService;
    
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addPersonnel(@RequestBody PersonnelRequestDto requestDto){
        try {
            PersonnelResponseDto responseDto=personnelService.addPersonnel(requestDto);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> getAllPersonnels(){
        try {
            List<PersonnelResponseDto> responseDto=personnelService.getAllPersonnels();
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }
}
