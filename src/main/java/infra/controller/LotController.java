package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.LotRequestDto;
import infra.dto.response.LotResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.service.ILotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.channels.Pipe;

@RestController
@RequestMapping("/lots")
public class LotController {
    private final ILotService lotService;

    public LotController(ILotService lotService) {
        this.lotService = lotService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addLot(@RequestBody LotRequestDto request){
        try {
            LotResponseDto responseDto=lotService.addLot(request);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Failure",null));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(
                    "Failure",null
            ));
        }
    }
}
