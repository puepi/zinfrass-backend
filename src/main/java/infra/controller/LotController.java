package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.LotRequestDto;
import infra.dto.request.UpdateRequestDto;
import infra.dto.response.LotResponseDto;
import infra.exception.ResourceNotFoundException;
import infra.service.ILotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.Pipe;
import java.util.List;

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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(
                    e.getMessage(),null
            ));
        }
    }
    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> getAllLots(){
        try {
            List<LotResponseDto> responseDto=lotService.getAllLots();
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Failure",null));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(
                    e.getMessage(),null
            ));
        }
    }

    @PutMapping("/change-quantity/{idLot}")
    public ResponseEntity<ApiResponse> getAllLots(@PathVariable Long idLot, @RequestBody UpdateRequestDto requestDto){
        try {
            LotResponseDto responseDto=lotService.changeQuantity(idLot,requestDto.getQty());
            return ResponseEntity.ok(new ApiResponse("Success",responseDto));
        } catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Failure",null));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(
                    e.getMessage(),null
            ));
        }
    }

    @DeleteMapping("/delete/{idLot}")
    public ResponseEntity<ApiResponse> getAllLots(@PathVariable Long idLot){
        try {
            lotService.deleteLot(idLot);
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
