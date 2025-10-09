package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.LotRequestDto;
import infra.dto.request.OctroiRequestDto;
import infra.dto.response.OctroiResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.service.IOctroiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/octrois")
@RequiredArgsConstructor
public class OctroiController {
    private final IOctroiService octroiService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addOctroi(@RequestBody OctroiRequestDto requestDto){
        try {
            OctroiResponseDto responseDto=octroiService.addOctroi(requestDto);
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> addOctroi(){
        try {
            List<OctroiResponseDto> responseDto=octroiService.getAllOctrois();
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }


    @DeleteMapping("/{idLot}/delete")
    public ResponseEntity<ApiResponse> getAllLots(@PathVariable Long idLot){
        try {
            octroiService.deleteOctroi(idLot);
            return ResponseEntity.ok(new ApiResponse("Success",null));
        } catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Failure",null));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(
                    e.getMessage(),null
            ));
        }
    }
}
