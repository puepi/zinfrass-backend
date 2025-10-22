package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.AppUserRequestDto;
import infra.dto.response.BatimentResponseDto;
import infra.model.AppUser;
import infra.service.IAppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final IAppUserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody AppUserRequestDto user){
        try {
            AppUser responseDto= userService.register(user);
            return ResponseEntity.ok(new ApiResponse("Success", responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody AppUserRequestDto user){
        try {
            String responseDto= userService.login(user);
            return ResponseEntity.ok(new ApiResponse("Success", responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(e.getMessage(),null));
        }
    }
}
