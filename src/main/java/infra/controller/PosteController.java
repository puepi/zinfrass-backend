package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.Mapper;
import infra.dto.request.PosteRequestDto;
import infra.dto.response.PosteResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.model.Poste;
import infra.service.PosteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postes")
public class PosteController {
    private final PosteService posteService;

    @Autowired
    public PosteController(PosteService posteService) {
        this.posteService = posteService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addPoste(@RequestBody PosteRequestDto requestDto){
        try {
            PosteResponseDto responseDto=posteService.addPoste(requestDto);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getPoste(@PathVariable Long id){
        try {
            Poste responseDto=posteService.getPoste(id);
            return ResponseEntity.ok(new ApiResponse("Success", Mapper.posteToPosteResponseDto(responseDto)));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> getAllPostes(){
        try {
            List<PosteResponseDto> responseDto=posteService.getAllPostes();
            return ResponseEntity.ok(new ApiResponse("Success", (responseDto)));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }
    @GetMapping("/getall/pagination")
    public ResponseEntity<ApiResponse> getPaginatedAllPostes(Pageable pageable){
        try {
            Page<PosteResponseDto> responseDto=posteService.getPaginatedAllPostes(pageable);
            return ResponseEntity.ok(new ApiResponse("Success", (responseDto)));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }
}
