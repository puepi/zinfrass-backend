package infra.controller;


import infra.api_response.ApiResponse;
import infra.dto.Mapper;
import infra.dto.request.SubdivisionRequestDto;
import infra.dto.response.SubdivisionResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.model.Subdivision;
import infra.repository.SubdivisionRepository;
import infra.service.ISubdivisionService;
import infra.service.SubdivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subdivisions")
public class SubdivisionController {
    private final ISubdivisionService subdivisionService;

    @Autowired
    public SubdivisionController(SubdivisionService service) {
        this.subdivisionService = service;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addSubdivision(@RequestBody SubdivisionRequestDto dto){
        try {
            SubdivisionResponseDto responseDto=subdivisionService.addSubdivisionWithParent(dto);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getSubdivision(@PathVariable Long id){
        try {
            Subdivision responseDto=subdivisionService.getSubdivision(id);
            return ResponseEntity.ok(new ApiResponse("Success", Mapper.subdivisionToSubdivisionResponseDto(responseDto)));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> getAllSubdivisions(){
        try {
            List<SubdivisionResponseDto> responseDto=subdivisionService.getAllSubdivisions();
            return ResponseEntity.ok(new ApiResponse("Success", (responseDto)));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/update-parent/{id}/{idParent}")
    public ResponseEntity<ApiResponse> rattacherParent(@PathVariable Long id,@PathVariable Long idParent){
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> rattacherParent(@PathVariable Long id){
        try {
            subdivisionService.deleteSubdivision(id);
            return ResponseEntity.noContent().build();
        }catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
