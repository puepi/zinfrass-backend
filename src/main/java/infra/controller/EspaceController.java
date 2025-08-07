package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.EspaceRequestDto;
import infra.dto.response.EspaceResponseDto;
import infra.service.IEspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/espaces")
@RestController
@RequiredArgsConstructor
public class EspaceController {
    private final IEspaceService espaceService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addEspace(@RequestBody EspaceRequestDto requestDto){
        try {
            EspaceResponseDto responseDto= espaceService.addEspace(requestDto);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }


    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> getAllEspaces(){
        try {
            List<EspaceResponseDto> responseDto= espaceService.getAllEspace();
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }
}
