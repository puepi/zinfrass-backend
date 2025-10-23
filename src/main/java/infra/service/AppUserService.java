package infra.service;

import infra.dto.Mapper;
import infra.dto.request.AppUserRequestDto;
import infra.exception.ResourceNotFoundException;
import infra.model.AppUser;
import infra.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService implements  IAppUserService{
    private final AppUserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AppUser register(AppUserRequestDto requestDto) {
        requestDto.setPassword(bCryptPasswordEncoder.encode(requestDto.getPassword()));
        return userRepository.save(Mapper.userRequestDtoToUser(requestDto));
    }

    @Override
    public boolean login(AppUserRequestDto user) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        if(authenticate.isAuthenticated())
            return true;
        return false;
    }
}
