package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.Mapper;
import infra.dto.request.StructureRequestDto;
import infra.dto.response.StructureResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.model.Structure;
import infra.repository.StructureRepository;
import infra.service.StructureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/structures")
public class StructureController {

    private final StructureService service;

    public StructureController(StructureService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addStructure(@RequestBody StructureRequestDto requestDto){
        try {
            StructureResponseDto responseDto=service.addStructure(requestDto);
            return ResponseEntity.ok(new ApiResponse("Succes",responseDto));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @PutMapping("/update-parent/{id}/{idParent}")
    public ResponseEntity<ApiResponse> addStructure(@PathVariable Long id,@PathVariable Long idParent){
        try {
            StructureResponseDto responseDto=service.rattacherParent(id,idParent);
            return ResponseEntity.ok(new ApiResponse("Succes",(responseDto)));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> addStructure(@PathVariable Long id){
        try {
            Structure responseDto=service.getStructure(id);
            return ResponseEntity.ok(new ApiResponse("Succes", Mapper.structureToStructureResponseDto(responseDto)));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> getAllStructures(){
        try {
            List<StructureResponseDto> responseDto=service.geAllStructures();
            return ResponseEntity.ok(new ApiResponse("Succes",responseDto));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/get-name")
    public ResponseEntity<ApiResponse> getByName(@RequestParam String name){
        try {
            List<StructureResponseDto> responseDto=service.getStructureByNameContaining(name);
            return ResponseEntity.ok(new ApiResponse("Succes",responseDto));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }
}
