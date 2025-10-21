package infra.controller;

import infra.api_response.ApiResponse;
import infra.dto.request.AppUserRequestDto;
import infra.model.AppUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody AppUserRequestDto user){

    }
}
