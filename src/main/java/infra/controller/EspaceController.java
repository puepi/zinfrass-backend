package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.EspaceRequestDto;
import infra.dto.response.EspaceResponseDto;
import infra.service.IEspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
