package infra.controller;


import infra.api_response.ApiResponse;
import infra.dto.request.SubdivisionRequestDto;
import infra.dto.response.SubdivisionResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.repository.SubdivisionRepository;
import infra.service.ISubdivisionService;
import infra.service.SubdivisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subdivisions")
public class SubdivisionController {
    private final ISubdivisionService subdivisionService;

    public SubdivisionController(SubdivisionService service) {
        this.subdivisionService = service;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addSubdivision(@RequestBody SubdivisionRequestDto dto){
        try {
            SubdivisionResponseDto responseDto=subdivisionService.addSubdivision(dto);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/add-parent")
    public ResponseEntity<ApiResponse> rattacherParent(Long id,Long idParent){
        try {
            SubdivisionResponseDto responseDto=subdivisionService.rattacherParent(id, idParent);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        }catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
