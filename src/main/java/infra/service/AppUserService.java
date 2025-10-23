package infra.service;

import infra.dto.Mapper;
import infra.dto.request.AppUserRequestDto;
import infra.model.AppUser;
import infra.repository.AppUserRepository;
import infra.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService implements  IAppUserService{
    private final AppUserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AppUser register(AppUserRequestDto requestDto) {
        requestDto.setPassword(bCryptPasswordEncoder.encode(requestDto.getPassword()));
        return userRepository.save(Mapper.userRequestDtoToUser(requestDto));
    }

    @Override
    public String login(AppUserRequestDto user) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        if(authenticate.isAuthenticated()){
            Object principal=authenticate.getPrincipal();
            if(principal instanceof CustomUserDetails theUser){
                System.out.println("username = " + (theUser.getUsername() + ", Roles :" + theUser.getAuthorities()));
            }
            String token=jwtService.generateToken(user);
            return token;
        }
        return "Failure";
    }
}
